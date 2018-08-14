package com.shopping.prac.IntegrationTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.prac.shoppingbeans.Product;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
public class ProductControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    public void testGetProductById() throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        String expected = "";
        ObjectMapper objectMapper = new ObjectMapper();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> responseEntity = testRestTemplate
                .exchange(createURLWithPort("/v1/products/1"),HttpMethod.GET, entity, String.class);

        Product p = new Product(1, "aa");
        try {
            expected = objectMapper.writeValueAsString(p);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        JSONAssert.assertEquals( expected, responseEntity.getBody(),false);
    }


    private String createURLWithPort(final String uri) {
        return "http://localhost:" + port + uri;
    }

}
