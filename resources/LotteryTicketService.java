package com.newsweaver.lotterysystem.resources;

import com.codahale.metrics.annotation.Timed;
import com.newsweaver.lotterysystem.core.TicketManager;
import com.newsweaver.lotterysystem.api.Ticket;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/lottery-ticket")
@Produces(MediaType.APPLICATION_JSON)
public class LotteryTicketService {

    private static TicketManager ticketManager;

    public LotteryTicketService() {
        ticketManager = new TicketManager();
    }

    @POST
    @Timed
    @Path("generateTicket")
    @Produces(MediaType.TEXT_PLAIN)
    public String generateTicket(@DefaultValue("3") @QueryParam("numberOfLines") int numberOfLines) {

        String successMessage = "Ticket generated with " + numberOfLines + " lines";
        String errorMessage = "Ticket already generated";

        if (ticketManager.isTicketGenerated()) {return errorMessage;}

        ticketManager.generateTicket(numberOfLines);
        return successMessage;

    }

    @POST
    @Timed
    @Path("checkTicketStatus")
    @Produces(MediaType.APPLICATION_JSON)
    public Ticket checkTicketStatus() {

        if (ticketManager.isTicketGenerated()) {return ticketManager.checkTicketStatus();}

        return null;

    }


    @POST
    @Timed
    @Path("addTicketLines")
    @Produces(MediaType.TEXT_PLAIN)
    public String addTicketLines(@DefaultValue("1") @QueryParam("numberOfLines") int numberOfLines) {

        String successMessage = numberOfLines + " new lines(s) added to ticket";
        String errorMessage = "Cannot modify ticket after ticket status has been checked";

        if (ticketManager.isStatusChecked()) {return errorMessage;}

        ticketManager.addLinesToTicket(numberOfLines);
        return successMessage;

    }

}
