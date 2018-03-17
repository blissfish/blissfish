package simple.web.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	private static final Logger log = LoggerFactory.getLogger(HelloRestController.class);

    @RequestMapping(value = "/api/hello", method = RequestMethod.GET, produces = { MediaType.TEXT_PLAIN_VALUE})
    public String helloText(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        log.info("TEXT "+model.toString());
        return "hello "+System.currentTimeMillis()+" from REST text/plain";
    }
    
    @RequestMapping(value = "/api/hello", method = RequestMethod.GET, produces = { MediaType.TEXT_HTML_VALUE})
    public String helloHtml(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        log.info("HTML "+model.toString());
        return "<style>*{host:inital}</style>\n" + 
        		"<style type=\"text/css\">\n" + 
        		"@import url(\"my-bootstrap.min.css\");\n" + 
        		".box-shadow {box-shadow: 0 .25rem .75rem rgba(0, 0, 0, .05);}\n" + 
        		"</style>\n" + 
        		"<div class=\"card mb-4 box-shadow\">\n" + 
        		"	<img style=\"cursor: pointer\" class=\"card-img-top\" src=\"Hello.svg\" alt=\"Card image cap\">\n" + 
        		"	<div class=\"card-body\">\n" + 
        		"		<p class=\"card-text\">"+System.currentTimeMillis()+" from REST text/html</p>\n" + 
        		"		<div class=\"d-flex justify-content-between align-items-center\">\n" + 
        		"			<div class=\"btn-group\">\n" + 
        		"				<button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">View</button>\n" + 
        		"				<button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">Edit</button>\n" + 
        		"			</div>\n" + 
        		"			<small class=\"text-muted\">9 mins</small>\n" + 
        		"		</div>\n" + 
        		"	</div>\n" + 
        		"</div>";

    }
}