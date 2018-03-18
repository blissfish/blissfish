package web0;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/service")
public class SimpleService2 {

	@GET
	@Path("/{param}")
    @Produces(javax.ws.rs.core.MediaType.TEXT_HTML)
	public Response getMsg(@PathParam("param") String msg) {
		String output = "<style>\r\n" + 
				"body {\r\n" + 
				"    display: block;\r\n" + 
				"    margin: 0px;\r\n" + 
				"}\r\n" + 
				".rcorners1 {\r\n" + 
				"	font-family: Arial, Helvetica, sans-serif;\r\n" + 
				"	font-size: 12px;\r\n" + 
				"    border-radius: 25px;\r\n" + 
				" 	background: linear-gradient(to right, blue, indigo);\r\n" + 
				" 	color: white;\r\n" + 
				"    padding: 20px;\r\n" + 
				"    width: 380px;\r\n" + 
				"    height: 180px;\r\n" + 
				"    box-shadow: 4px 4px 6px #000000;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"\r\n" + 
				"<div id=\"widget\" class=\"rcorners1\">\r\n" + 
				"	<h1>Widget</h1>\r\n" + 
				"	<p> Jersey says : "+ msg+"</p>\r\n" + 
				"</div>";
		
//	    cres.getHeaders().add("Access-Control-Allow-Origin", "*");
//	      cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
//	      cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
//	      cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
//	      cres.getHeaders().add("Access-Control-Max-Age", "1209600");
		return Response.status(200).entity(output).header("Access-Control-Allow-Origin", "*").build();
	}
	

}