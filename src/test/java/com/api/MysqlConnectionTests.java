package com.api;

import javax.sql.DataSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.config.import=optional:file:.env"
})
@ActiveProfiles("mysql")
class MysqlConnectionTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void shouldConnectToMysql() throws Exception {
        var connection = dataSource.getConnection();
        assertTrue(connection.isValid(2));
        connection.close();

    }
}
