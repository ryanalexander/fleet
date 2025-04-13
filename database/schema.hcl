table "job" {
  schema = schema.fleet
  column "id" {
    null = false
    type = integer
    identity {
      generated = ALWAYS
    }
  }
  primary_key "job_pk" {
    columns = [column.id]
  }
}
schema "fleet" {
}
