package com.upwork.test.dao;

import org.springframework.stereotype.Component;

/**
 * Created by Titan on 18.04.2017.
 */
@Component
public class TicketDao {

    public Boolean isTicketAvailable(Long ticketId) {
        return stubTicketIsAvailable();
    }

    private boolean stubTicketIsAvailable() {
        return true;
    }
}
