package dev.kotylu.rest;

import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import dev.kotylu.service.api.MessageService;
import javassist.NotFoundException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class MessageController {

    @Autowired
    private final MessageService messageService;

    public MessageController(@ComponentImport("basic") MessageService messageService) {
        this.messageService = messageService;
    }

    @GET
    @Path("{issueKey}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll(@PathParam("issueKey") String issueKey)
    {
        try {
            return Response.ok(new JSONObject(this.messageService.getMessage(issueKey))).build();
        } catch (NotFoundException e) {
            return Response.serverError().build();
        }
    }
}
