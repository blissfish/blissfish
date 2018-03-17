package simple.web.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = { MediaType.TEXT_PLAIN_VALUE})
    public String helloText(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        log.info("TEXT "+model.toString());
        return "hello";//+System.currentTimeMillis()+" from JSP text/plain";
    }
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = { MediaType.TEXT_HTML_VALUE})
    public String helloHtml(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        log.info("HTML "+model.toString());

        return "hello";
    }
    

}
