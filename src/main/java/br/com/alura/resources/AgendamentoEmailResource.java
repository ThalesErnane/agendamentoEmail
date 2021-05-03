package br.com.alura.resources;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;
import br.com.alura.exception.BusinessException;

@Path("/agendamentoemail")
public class AgendamentoEmailResource {
	
	private static Logger logger = Logger.getLogger(AgendamentoEmailResource.class.getName());
	
	@Inject
	private AgendamentoEmailBusiness agendamentoEmailBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarAgendamentosEmail() {
		List<AgendamentoEmail> emails = agendamentoEmailBusiness.listarAgemndamentosEmail();
			return Response.ok(emails).build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail ) throws BusinessException {
		
		agendamentoEmailBusiness.salvarAgendamentoEmail(agendamentoEmail);

		return Response
				.status(201)
				.build();
		
	}

}
