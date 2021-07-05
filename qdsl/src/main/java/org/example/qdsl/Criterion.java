package org.example.qdsl;

import lombok.Data;

@Data
public class Criterion {

  public enum BOOLEAN_OPERATOR {
    AND,
    OR,
    NOT
  }
}
