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

public class TestGames {

	@Autowired
	private MockMvc server;

	/*
	 * Test: se envia una petición get al juego nm y se espera un estado isOK()
	 */

	@Test
	void testRequestMatch() throws Exception {

		String payloadPepe = sendRequest("Pepe");
		JSONObject jsoPepe = new JSONObject(payloadPepe);
		assertFalse(jsoPepe.getBoolean("ready"));

		String payloadAna = sendRequest("Ana");
		JSONObject jsoAna = new JSONObject(payloadAna);
		assertTrue(jsoAna.getBoolean("ready"));
		
		assertTrue(jsoAna.getJSONArray("boards").length()==2);
		
	}

	private String sendRequest(String player) throws Exception, UnsupportedEncodingException {
		RequestBuilder request = MockMvcRequestBuilders.get("/games/requestGame?juego=nm&player=" + player);

		ResultActions resultactions = this.server.perform(request);
		MvcResult result = resultactions.andExpect(status().isOk()).andReturn();

		MockHttpServletResponse response = result.getResponse();
		String payload = response.getContentAsString();

		return payload;
	}

	/*
	 * Test: se envia una petición get al juego trivial y se espera un estado
	 * isNotFound()
	 */

	@Test
	void testRequestMatchTrivial() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/games/requestGame?juego=trivial&player=Juan");
		this.server.perform(request).andExpect(status().isNotFound());
	}

}
