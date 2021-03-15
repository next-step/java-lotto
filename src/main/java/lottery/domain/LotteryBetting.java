package lottery.domain;

import lottery.dto.LotteryTicketProxy;
import lottery.dto.ReadonlyLotteryTicket;

public class LotteryBetting {

    private LotteryTicket lotteryTicket;

    public LotteryBetting(int money) {
        lotteryTicket = LotteryTicketIssuer.issue(money);
    }

    public ReadonlyLotteryTicket getLotteryTicket() {
        return new LotteryTicketProxy(lotteryTicket);
    }

}
