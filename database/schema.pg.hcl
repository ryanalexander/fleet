schema "fleet" {
}

table "event_type" {
  schema = schema.fleet

  column "code" {
    null = false
    type = varchar
  }

  column "description" {
    null = false
    type = varchar
  }

  primary_key "event_type_pk" {
    columns = [column.code]
  }
}

table "person" {
  schema = schema.fleet

  column "id" {
    null = false
    type = integer
    identity {
      generated = ALWAYS
    }
  }

  column "name" {
    null = false
    type = varchar
  }

  column "phone" {
    null = true
    type = varchar
  }

  column "created_at" {
    null = false
    type = timestamp
  }

  column "updated_at" {
    null = false
    type = timestamp
  }

  primary_key "person_pk" {
    columns = [column.id]
  }
}

table "job" {
  schema = schema.fleet

  column "id" {
    null = false
    type = integer
    identity {
      generated = ALWAYS
    }
  }

  column "sender_id" {
    null = true
    type = integer
  }

  column "receiver_id" {
    null = true
    type = integer
  }

  column "service_window_start" {
    null = true
    type = timestamp
  }

  column "service_window_end" {
    null = true
    type = timestamp
  }

  column "created_at" {
    null = false
    type = timestamp
  }

  column "updated_at" {
    null = false
    type = timestamp
  }

  foreign_key "job_sender_fk" {
    columns     = [column.sender_id]
    ref_columns = [table.person.column.id]
  }

  foreign_key "job_receiver_fk" {
    columns     = [column.receiver_id]
    ref_columns = [table.person.column.id]
  }

  primary_key "job_pk" {
    columns = [column.id]
  }
}

table "location" {
  schema = schema.fleet

  column "id" {
    null = false
    type = integer
    identity {
      generated = ALWAYS
    }
  }

  column "name" {
    null = false
    type = varchar
  }

  column "address" {
    null = false
    type = varchar
  }

  column "latitude" {
    null = false
    type = float8
  }

  column "longitude" {
    null = false
    type = float8
  }

  column "notes" {
    null = false
    type = text
  }

  column "created_at" {
    null = false
    type = timestamp
  }

  column "updated_at" {
    null = false
    type = timestamp
  }

  primary_key "location_pk" {
    columns = [column.id]
  }
}

table "job_location" {
  schema = schema.fleet

  column "id" {
    null = false
    type = integer
    identity {
      generated = ALWAYS
    }
  }

  column "job_id" {
    null = false
    type = integer
  }

  column "type" {
    null = false
    type = varchar
  }

  column "location_id" {
    null = false
    type = integer
  }

  foreign_key "jl_job_fk" {
    columns     = [column.job_id]
    ref_columns = [table.job.column.id]
  }

  foreign_key "jl_location_fk" {
    columns     = [column.location_id]
    ref_columns = [table.location.column.id]
  }

  primary_key "job_location_pk" {
    columns = [column.id]
  }
}

table "driver" {
  schema = schema.fleet

  column "id" {
    null = false
    type = integer
    identity {
      generated = ALWAYS
    }
  }

  column "hr_id" {
    null = false
    type = varchar
  }

  column "name" {
    null = false
    type = varchar
  }

  column "created_at" {
    null = false
    type = timestamp
  }

  column "updated_at" {
    null = false
    type = timestamp
  }

  primary_key "driver_pk" {
    columns = [column.id]
  }
}

table "job_attachments" {
  schema = schema.fleet

  column "id" {
    null = false
    type = integer
    identity {
      generated = ALWAYS
    }
  }

  column "job_id" {
    null = false
    type = integer
  }

  column "attachment_type" {
    null = false
    type = varchar
  }

  column "attachment_url" {
    null = false
    type = varchar
  }

  foreign_key "ja_job_fk" {
    columns     = [column.job_id]
    ref_columns = [table.job.column.id]
  }

  primary_key "job_attachments_pk" {
    columns = [column.id]
  }
}

table "job_events" {
  schema = schema.fleet

  column "id" {
    null = false
    type = integer
    identity {
      generated = ALWAYS
    }
  }

  column "job_id" {
    null = false
    type = integer
  }

  column "event_type" {
    null = false
    type = varchar
  }

  column "event_time" {
    null = false
    type = timestamp
  }

  column "comment" {
    null = false
    type = text
  }

  column "driver" {
    null = false
    type = integer
  }

  column "gps_latitude" {
    null = true
    type = float8
  }

  column "gps_longitude" {
    null = true
    type = float8
  }

  column "metadata" {
    null = true
    type = jsonb
  }

  foreign_key "je_job_fk" {
    columns     = [column.job_id]
    ref_columns = [table.job.column.id]
  }

  foreign_key "je_event_type_fk" {
    columns     = [column.event_type]
    ref_columns = [table.event_type.column.code]
  }

  foreign_key "je_driver_fk" {
    columns     = [column.driver]
    ref_columns = [table.driver.column.id]
  }

  index "idx_job_events_job_time" {
    columns = [column.job_id, column.event_time]
  }

  index "idx_job_events_driver" {
    columns = [column.driver]
  }

  primary_key "job_events_pk" {
    columns = [column.id]
  }
}
