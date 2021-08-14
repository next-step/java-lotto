/*
 * AutoTicketMaker.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.strategy;

import edu.nextstep.lottoauto.ticket.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoTicketMaker implements TicketMaker {
    private static final List<Integer> TOTAL_NUMBERS = new ArrayList<>();

    static{
        initTotalNumbers();
    }

    private static void initTotalNumbers() {
        for (int i = 1; i <= 45; i++) {
            TOTAL_NUMBERS.add(i);
        }
    }

    @Override
    public Ticket makeTicket() {
        return null;
    }

    protected void flushingTotalNumbers(){
        Collections.shuffle(TOTAL_NUMBERS);
    }

    protected static void sortTotalNumbers(){
        Collections.sort(TOTAL_NUMBERS);
    }
}
