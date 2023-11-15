package step2.domain;

import java.util.List;

public class LotteryTicket {

    private List<Integer> lotteryTicketNumbers;

    public LotteryTicket(final List<Integer> lotteryNumbers) {
        this.lotteryTicketNumbers = lotteryNumbers;
    }

    public List<Integer> getLotteryTicketNumbers() {
        return lotteryTicketNumbers;
    }
}
