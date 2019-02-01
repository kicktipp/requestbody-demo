package com.example.requestbodydemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testValidForm() {
        Form form = new Form();
        form.setPositiveInteger(3);
        webTestClient
                .post()
                .uri("/form")
                .syncBody(form)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.anzahlFehler").isEqualTo("0");
    }

    @Test
    public void testInvalidForm() {
        Form form = new Form();
        // invalid but bindable
        form.setPositiveInteger(-3);
        webTestClient
                .post()
                .uri("/form")
                .syncBody(form)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.anzahlFehler").isEqualTo("1");
    }

    @Test
    public void testBindingResult() {
        FakeForm form = new FakeForm();
        webTestClient
                .post()
                .uri("/form")
                .syncBody(form)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.anzahlFehler").isEqualTo("1");
    }
}
