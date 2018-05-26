package data.factory.service;


import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {
	private static final DataFactory df = new DataFactory();
	private static final Logger log = LoggerFactory.getLogger(MyUserService.class);

	public User api() {
		User user = new User(df.getFirstName(), df.getLastName(), df.getAddress(), df.getCity(), df.getBusinessName(), df.getEmailAddress());
		log.info(user.toString());
		return user;
	}
}