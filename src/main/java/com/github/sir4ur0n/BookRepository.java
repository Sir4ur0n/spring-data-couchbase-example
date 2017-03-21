package com.github.sir4ur0n;

import java.util.Collection;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Julien Debon
 */
public interface BookRepository extends CrudRepository<Book, Long> {

  /**
   * Does not work.<br/> It correctly returns the books matching, but does not delete them.<br/> Using a "void" or
   * "Void" return type results in an exception:<br/> "CouchbaseQueryExecutionException: Query returning a primitive
   * type are expected to return exactly 1 result, got (number of matching documents)"
   */
  Collection<Book> deleteByName(String name);

  /**
   * Works.
   */
  @Query("DELETE FROM `tesseract-data` WHERE #{#n1ql.filter} AND name=$1")
  Collection<Book> deleteByNameWithN1QL(String name);

}
