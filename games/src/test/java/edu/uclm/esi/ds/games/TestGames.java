package edu.uclm.esi.ds.games;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc

public class TestGames {
	
	@Autowired
	private MockMvc server;
	
	@Test
	void testRequestMatch() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.
			get("/games/requestGame?juego=nm");
			this.server.perform(request).andExpect(status().isOk());
	}
	
	
}
