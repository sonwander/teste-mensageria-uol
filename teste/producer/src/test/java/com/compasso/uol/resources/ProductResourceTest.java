package com.compasso.uol.resources;

import com.compasso.uol.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductResourceTest {
	@Autowired
	public MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	private static final String BASE_URI = "/api/products/";


	@Test
	public void test_Cadastrar_Um_Produto_Fila_RabbitMQ() throws Exception {
		String product = "{\"name\": \"Produto teste foo bar\", \"description\": \"Descrição do Produto foo bar\", \"price\": 198.30}";

		when(productService.insert(any()))
				.thenReturn(any());

		mockMvc.perform(post(BASE_URI)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(product))
				.andExpect(status().isCreated());
	}


	@Test
	public void test_Cadastrar_Varios_Produtos_Fila_RabbitMQ() throws Exception {
		mockMvc.perform(post(BASE_URI + "/auto")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
}