package edu.uclm.esi.ds.games.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.uclm.esi.ds.games.dao.UserDAO;
import edu.uclm.esi.ds.games.entities.User;

@Service
public class UsersService {
	
	@Autowired
	private UserDAO userDAO;

	public void register(String name, String email, String pwd1) {
		// crea un objeto user y luego tiene que llegar almacenar el objeto en la bbdd. Aqui la info ya ha llegado validada desde el controller
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPwd(pwd1);
		
		this.userDAO.save(user);
		
	}

}
