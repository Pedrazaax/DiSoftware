package edu.uclm.esi.ds.games.http;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import edu.uclm.esi.ds.games.services.UsersService;

@RestController
@RequestMapping("users")
public class UsersController {

	@Autowired
	UsersService usersService;

	@PostMapping("/register")
	public void register(@RequestBody Map<String, Object> info) {
		String name = info.get("name").toString();
		String email = info.get("email").toString();
		String pwd1 = info.get("pwd1").toString();
		String pwd2 = info.get("pwd2").toString();
		
		if (!pwd1.equals(pwd2))
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "No coinciden las contraseñas");
	
		try {
			this.usersService.register(name,email,pwd1);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		
	}
	
	@PutMapping("/login")
	public void login(@RequestBody Map<String, Object> info) {
		String name = info.get("name").toString();
		String pwd = info.get("pwd").toString();
		
		try {
			this.usersService.login(name,pwd);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		
	}
	
}
