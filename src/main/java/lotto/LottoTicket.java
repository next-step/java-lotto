package lotto;

import java.util.*;

public class LottoTicket {
    private List<Integer> ticket = new ArrayList<>();
    private int MAX_COUNT = 6;

    public LottoTicket(Random random) {
        while (ticket.size() < MAX_COUNT) {
            int randomNumber = random.nextInt(45) + 1;
            addNumber(randomNumber);
        }
        Collections.shuffle(ticket);
        Collections.sort(ticket);
    }

    private void addNumber(int randomNumber) {
        if (!ticket.contains(randomNumber)) {
            ticket.add(randomNumber);
        }
    }

    @Override
    public String toString() {
        return this.ticket.toString();
    }
}
