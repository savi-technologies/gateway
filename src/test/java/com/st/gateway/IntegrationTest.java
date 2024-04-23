package com.st.gateway;

import com.st.gateway.config.AsyncSyncConfiguration;
import com.st.gateway.config.EmbeddedElasticsearch;
import com.st.gateway.config.EmbeddedSQL;
import com.st.gateway.config.JacksonConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { GatewayApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
public @interface IntegrationTest {
    // 5s is Spring's default https://github.com/spring-projects/spring-framework/blob/main/spring-test/src/main/java/org/springframework/test/web/reactive/server/DefaultWebTestClient.java#L106
    String DEFAULT_TIMEOUT = "PT5S";

    String DEFAULT_ENTITY_TIMEOUT = "PT5S";
}
