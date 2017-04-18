package com.upwork.test.service;

import com.upwork.test.dao.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Titan on 18.04.2017.
 */
@Component
public class TicketService {

    @Autowired
    private TicketDao ticketDao;

    public Boolean isTicketAvailable(Long ticketId) {
        return ticketDao.isTicketAvailable(ticketId);
    }
}
