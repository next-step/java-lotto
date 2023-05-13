package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step2.Lotto.*;

public class Ticket {

    private List<Integer> ticket;

    public Ticket() {
        createTicket();
        System.out.println("ticket = " + ticket);
    }

    public List<Integer> getTicket() {
        return this.ticket;
    }

    public List<Integer> createTicket() {

        Collections.shuffle(Lotto.lottoNumber);
        this.ticket = Lotto.lottoNumber.subList(0,6);
        Collections.sort(ticket);

        return this.ticket;
    }

}