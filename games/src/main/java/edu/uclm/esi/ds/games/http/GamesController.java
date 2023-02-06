package edu.uclm.esi.ds.games.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("games")
public class GamesController {

	@GetMapping("/requestGame")
	public String requestGame(@RequestParam String juego) {
		return "Bienvenido al " + juego;
	}
}
