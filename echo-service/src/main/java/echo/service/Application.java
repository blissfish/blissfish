package echo.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class Application {
	
	@Value("${version}")
	private String version;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
    	String host = getHostName();
    	String response = ":" + name + "!\n";    	 
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