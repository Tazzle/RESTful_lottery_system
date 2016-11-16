package com.newsweaver.lotterysystem.core;

import com.newsweaver.lotterysystem.api.Ticket;
import com.newsweaver.lotterysystem.api.Line;

import java.util.*;


public class TicketManager {

    private static Boolean statusChecked;
    private static Boolean ticketGenerated;
    private static Ticket ticket;
    private static List<Line> lines;


    public TicketManager() {

        statusChecked = false;
        ticketGenerated = false;
        lines = new ArrayList<>();
    }


    public void addLinesToTicket(int numberOfLines) {

        for (int i = 0; i < numberOfLines; i++) {
            lines.add(new Line());
        }
    }

    public Ticket checkTicketStatus() {

        statusChecked = true;
        ticket.sortLines();
        return ticket;

    }

    public void generateTicket(int numberOfLines) {

        for (int i = 0; i < numberOfLines; i++) {
            lines.add(new Line());
        }

        ticket = new Ticket(UUID.randomUUID().toString(), lines);

        ticketGenerated = true;

    }

    public Boolean isTicketGenerated() {
        return ticketGenerated;
    }

    public Boolean isStatusChecked() {
        return statusChecked;
    }


}
