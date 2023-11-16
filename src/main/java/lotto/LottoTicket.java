package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoTicket {
    private List<Integer> ticket = new ArrayList<>();

    public LottoTicket(Random random) {
        for (int i = 0; i < 6 ; i++) {
            int randomNumber = random.nextInt(100 - 1) + 1;
            ticket.add(randomNumber);
        }
        Collections.shuffle(ticket);
        Collections.sort(ticket);
    }
}
