package com.stelch.fleet.handlers;

public class ResponseHandler {

    public static Object getResponse(Object response, boolean success) {
        return new ResponseData(success, response);
    }

    private static class ResponseData {
        private final boolean success;
        private final Object data;

        public ResponseData(boolean success, Object data) {
            this.success = success;
            this.data = data;
        }

        public boolean isSuccess() {
            return success;
        }

        public Object getData() {
            return data;
        }
    }

}
