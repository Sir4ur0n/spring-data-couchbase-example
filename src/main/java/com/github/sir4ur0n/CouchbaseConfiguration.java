package com.github.sir4ur0n;

import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

/**
 * @author Julien Debon
 */
@Configuration
@EnableCouchbaseRepositories
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

  @Override
  protected List<String> getBootstrapHosts() {
    return Collections.singletonList("localhost");
  }

  @Override
  protected String getBucketName() {
    return "my-bucket";
  }

  @Override
  protected String getBucketPassword() {
    return "my-bucket-password";
  }

}
