package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusik on 2019/11/04.
 */
public class LotteryGenerator {

    private static final int SIZE = 6;
    private static final int TICKET_PRICE = 1_000;

    private final NumberGenerator numberGenerator;

    public LotteryGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<LotteryTicket> generate(int amount) {

        List<LotteryTicket> tickets = new ArrayList<>();
        int count = amount / TICKET_PRICE;
        for (int i = 0; i < count; i++) {
            tickets.add(generate());
        }
        return tickets;
    }

    public LotteryTicket generate() {
        return new LotteryTicket(numberGenerator.generate(SIZE));
    }
}
