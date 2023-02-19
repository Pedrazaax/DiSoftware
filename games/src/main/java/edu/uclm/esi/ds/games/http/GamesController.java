package edu.uclm.esi.ds.games.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import edu.uclm.esi.ds.games.domain.Match;
import edu.uclm.esi.ds.games.services.GamesService;

@RestController
@RequestMapping("games")
public class GamesController {
	
	@Autowired
	private GamesService gamesService;

	@GetMapping("/requestGame")
	public Match requestGame(@RequestParam String juego, @RequestParam String player) {
		if(!juego.equals("nm"))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el juego");
		
		return this.gamesService.requestGame(juego, player);
		
	}
}
