package com.stelch.fleet.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class WebEmbeddable {

    /**
     * Recursively fetch all declared fields, including from superclasses
     */
    private List<Field> getAllFields() {
        List<Field> fields = new ArrayList<>();
        Class<?> currentClass = this.getClass();
        while (currentClass != null && currentClass != Object.class) {
            Field[] declaredFields = currentClass.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                fields.add(field);
            }
            currentClass = currentClass.getSuperclass();
        }
        return fields;
    }

    /**
     * Default toString — prints all fields and values
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Field field : getAllFields()) {
            try {
                Object value = field.get(this);
                sb.append(field.getName()).append(": ")
                        .append(valueToString(value)).append("\n");
            } catch (IllegalAccessException e) {
                sb.append(field.getName()).append(": [access denied]\n");
            }
        }
        return sb.toString();
    }

    /**
     * toString with selected fields
     */
    public String toString(String[] fields) {
        StringBuilder sb = new StringBuilder();
        for (String fieldName : fields) {
            try {
                Field field = getFieldByName(fieldName);
                Object value = field.get(this);
                sb.append(fieldName).append(": ")
                        .append(valueToString(value)).append("\n");
            } catch (Exception e) {
                sb.append(fieldName).append(": [error retrieving value]\n");
            }
        }
        return sb.toString();
    }

    /**
     * Dynamically returns a map-like representation of this object.
     */
    public java.util.Map<String, Object> toObject() {
        java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
        for (Field field : getAllFields()) {
            try {
                Object value = field.get(this);
                map.put(field.getName(), value);
            } catch (IllegalAccessException e) {
                map.put(field.getName(), null);
            }
        }
        return map;
    }

    public java.util.Map<String, Object> toObject(String[] fields) {
        java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
        for (String fieldName : fields) {
            try {
                Field field = getFieldByName(fieldName);
                Object value = field.get(this);
                map.put(fieldName, value);
            } catch (Exception e) {
                map.put(fieldName, null);
            }
        }
        return map;
    }

    /**
     * Helper to get a declared field (even from superclasses)
     */
    private Field getFieldByName(String name) throws NoSuchFieldException {
        Class<?> clazz = this.getClass();
        while (clazz != null && clazz != Object.class) {
            try {
                Field field = clazz.getDeclaredField(name);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException ignored) {
                clazz = clazz.getSuperclass();
            }
        }
        throw new NoSuchFieldException(name);
    }

    /**
     * Handles more complex value printing
     */
    private String valueToString(Object value) {
        if (value == null) return "null";
        if (value.getClass().isArray())
            return java.util.Arrays.deepToString((Object[]) value);
        return value.toString();
    }
}
