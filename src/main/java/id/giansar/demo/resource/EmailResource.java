package id.giansar.demo.resource;

import id.giansar.demo.dto.MailDto;
import id.giansar.demo.service.EmailService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/mail")
public class EmailResource {

    @Inject
    EmailService emailService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendEmail(MailDto mailDto) {
        return emailService.sendMail(mailDto);
    }
}
