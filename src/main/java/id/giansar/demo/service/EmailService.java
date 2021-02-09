package id.giansar.demo.service;

import id.giansar.demo.dto.MailDto;
import id.giansar.demo.dto.ResponseDto;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class EmailService {

    private static final Logger LOGGER = Logger.getLogger("MailService");

    @Inject
    Mailer mailer;

    public Response sendMail(MailDto mailDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.status = "000";
        responseDto.message = "SUCCESS";
        Mail mail = Mail.withText(mailDto.recipient, mailDto.subject, mailDto.body);
        try {
            mailer.send(mail);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            responseDto.status = "101";
            responseDto.message = "Mail can not be sent";
            return Response.status(500).entity(responseDto).build();
        }
        return Response.ok(responseDto).build();
    }
}
