package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step2.Lotto.*;

public class Ticket {

    private List<Integer> ticket;

    public Ticket() {
        createTicket();
    }
    public Ticket(List<Integer> numbers){
        ticket = numbers;
    }

    public List<Integer> getTicket() {
        return ticket;
    }

    public List<Integer> createTicket() {

        Collections.shuffle(lottoNumber);
        ticket = new ArrayList<>(lottoNumber.subList(0,6));
        Collections.sort(ticket);

        return ticket;
    }

}