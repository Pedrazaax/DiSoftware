package edu.uclm.esi.ds.games;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc

public class TestUser {

	@Autowired
	private MockMvc server;

	/*
	 * Test: Usamos TDD para hacer un caso de uso de registro
	 */

	@Test
	void testRegister() throws Exception {
		ResultActions result = this.sendRequest("Pepe", "pepe@pepe.com", "pepe1234", "pepe1234");
		result.andExpect(status().isOk()).andReturn();
		
		result = this.sendRequest("Ana", "ana@ana.com", "ana1234", "ana1234");
		result.andExpect(status().isOk()).andReturn();
	}

	private ResultActions sendRequest(String name, String email, String pwd1, String pwd2)
			throws Exception, UnsupportedEncodingException {
		JSONObject jsoUser = new JSONObject()
				.put("name", name)
				.put("email", email)
				.put("pwd1", pwd1)
				.put("pwd2", pwd2);

		RequestBuilder request = MockMvcRequestBuilders
				.post("/users/register")
				.contentType("application/json")
				.content(jsoUser.toString());

		ResultActions resultActions = this.server.perform(request);
		return resultActions;
	}

}
