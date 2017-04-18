package com.upwork.test.controller;

import com.upwork.test.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Titan on 18.04.2017.
 */
@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/isAvailable")
    public Boolean isTicketAvailable(
            @RequestParam("id") Long ticketId
    ) {
        return ticketService.isTicketAvailable(ticketId);
    }

}
