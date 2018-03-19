package web0;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


@Path("/service")
public class SimpleService {

	@GET
	@Path("/{param}")
    @Produces(javax.ws.rs.core.MediaType.TEXT_HTML)
	public Response getMsg(@PathParam("param") String msg) {
		String output = "<style>host{all:inital}</style>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"@import url(\"my-bootstrap.min.css\");\r\n" +
				".box-shadow {box-shadow: 9px 11px 15px #666666;}\r\n"+				 
				"</style>\r\n" + 
				"<div class=\"card mb-4 box-shadow\">\r\n" + 
				"	<img style=\"cursor: pointer\" class=\"card-img-top\" src=\"Hello.svg\" alt=\"Card image cap\">\r\n" + 
				"	<div class=\"card-body\">\r\n" + 
				"		<p class=\"card-text\"> "+ msg+" from Jersey (" +new Date(System.currentTimeMillis())+")</p>\r\n" + 
				"		<div class=\"d-flex justify-content-between align-items-center\">\r\n" + 
				"			<div class=\"btn-group\">\r\n" + 
				"				<button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">View</button>\r\n" + 
				"				<button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">Edit</button>\r\n" + 
				"			</div>\r\n" + 
				"			<small class=\"text-muted\">9 mins</small>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"</div>";

		ResponseBuilder builder = Response.status(200).entity(output);
		return builder.build();
	}
	

}