package org.example.qdsl;

import lombok.Data;

@Data
public class Query {
  private BooleanGroup[] criterion;
}
