package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottosAutoGenerator implements LottosGenerator {
    @Override
    public List<Ticket> generate(Amount amount) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        while (amount.canPurcharse(1)) {
            amount.purcharseTicket(1);
            tickets.add(new Ticket(LottoNum.getRandNums()));
        }

        return tickets;
    }
}
