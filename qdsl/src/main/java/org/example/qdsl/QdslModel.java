package org.example.qdsl;

import lombok.Data;

@Data
public class QdslModel {
  private Query query;
  private String fields;
  private boolean countOnly;
  private int offset;
  private int limit;
  private int page;
}
