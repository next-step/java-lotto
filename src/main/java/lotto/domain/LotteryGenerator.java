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

    public List<LotteryTicket> generate(int amount, List<List<Integer>> manualLotteries) {

        List<LotteryTicket> tickets = new ArrayList<>();

        int manualCount = manualLotteries.size();
        for (int i = 0; i < manualCount; i++) {
            tickets.add(generateManualTicket(manualLotteries.get(i)));
        }

        int autoCount = (amount - manualCount * TICKET_PRICE) / TICKET_PRICE;
        for (int i = 0; i < autoCount; i++) {
            tickets.add(generateAutoTicket());
        }
        return tickets;
    }

    public LotteryTicket generateManualTicket(List<Integer> numbers) {
        return new LotteryTicket(numbers);
    }

    public LotteryTicket generateAutoTicket() {
        return new LotteryTicket(numberGenerator.generate(SIZE));
    }
}
