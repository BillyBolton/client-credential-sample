package org.example;

import org.springframework.context.annotation.Profile;
import org.testcontainers.junit.jupiter.Testcontainers;

@Profile("tc")
@Testcontainers
public class SampleIntegrationTest {

  // // container {
  // @Container
  // public GenericContainer<?> redis = new
  // GenericContainer<>(DockerImageName.parse("postgres")).withExposedPorts(5432);
  // // }

  // @BeforeEach
  // public void setUp() {
  // String address = redis.getHost();
  // Integer port = redis.getFirstMappedPort();

  // System.out.println(String.format("%s:%s", address, port));

  // // Now we have an address and port for Redis, no matter where it is running
  // // underTest = new RedisBackedCache(address, port);
  // }

  // @Test
  // public void testSimplePutAndGet() {
  // assertEquals("example", "example");
  // }
}
