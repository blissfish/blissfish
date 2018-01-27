package preferences.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class PreferencesService implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(PreferencesService.class);

	public static void main(String args[]) {
		SpringApplication.run(PreferencesService.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... arg0) throws Exception {
		log.info("Querying for preferences records ...");
		jdbcTemplate
				.query("SELECT id, uid, key, value FROM preferences ", (rs, rowNum) -> new Preferences(rs.getString("id"),rs.getString("uid"), rs.getString("key"),rs.getString("value")))
				.forEach(preferences -> log.info(preferences.toString()));
	}

}