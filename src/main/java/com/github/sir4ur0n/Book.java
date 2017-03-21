package com.github.sir4ur0n;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * @author Julien Debon
 */
@Document
@Data
class Book {

  @Id
  private UUID id;

  @Field
  private String name;

}
