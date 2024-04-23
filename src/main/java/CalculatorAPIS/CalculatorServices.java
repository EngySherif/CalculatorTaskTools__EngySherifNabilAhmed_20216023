package CalculatorAPIS;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejbs.Calculation;

@Stateless
@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculatorServices {
	
	@PersistenceContext(unitName= "calculate")
	private EntityManager entityManager;
	
		
	  @POST
	  @Path("/calc")
	  public Response CreateCalculation(Calculation calculation)
		
	  {  	  int result=0;

		  try {
			  
			  if(calculation.getOperation().equals("-"))
				  result=calculation.subtract();
			  
			  else if(calculation.getOperation().equals("+"))
				  result=calculation.add();
			  
			  else if(calculation.getOperation().equals("/"))
				  result=calculation.divide();
			  
			  else if(calculation.getOperation().equals("*"))
				  result=calculation.multiply();
				  
		  entityManager.persist(calculation);
		  
		  return Response.ok(result).build();
		  
		  }
		  
		  catch(Exception exception)
		  {
		
		  return Response.serverError().entity(exception.getMessage()).build();
		  }
		  
		 
	  }
	  @GET
	  @Path("/calculations")
	  public Response getAllCalculations()
	  {
		  try {
			  
			  return Response.ok(entityManager.createQuery("select cal from Calculation cal").getResultList()).build();
		  }
			  catch(Exception exception)
			  {
			
			  return Response.serverError().entity(exception.getMessage()).build();
			  }
	  
	  }
}
