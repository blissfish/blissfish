package echo.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Value("${version}")
	private String version;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @RequestMapping("/")
    String echo() {		
    	return echo("echo-service called...");
    }

    @RequestMapping("/{message}")
    String echo(@PathVariable String message) {
		log.info(message);
    	String host = getHostName();
    	String response = message + "\n";    	 
    	response += "Version: " + version + "\n";
    	response += ((host!=null)?"Host: "+host+"\n":"");
    	
    	return response;
    }

	private String getHostName() {
		String host = "";
    	 try {
			host = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return host;
	}
}