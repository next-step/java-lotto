package lotto.domain;

import lotto.domain.product.FinalResult;
import lotto.domain.product.lotto.LotteryTickets;
import lotto.domain.product.lotto.WinningTicket;

import java.util.List;
import java.util.Set;

public class PaymentHistory {

    private final LotteryTickets manualLotteryTickets;
    private final LotteryTickets autoLotteryTickets;

    private PaymentHistory(LotteryTickets manual, LotteryTickets auto) {
        this.manualLotteryTickets = manual;
        this.autoLotteryTickets = auto;
    }

    public PaymentHistory(Quantity auto, LotteryTickets manualLotteryTickets) {
        this(manualLotteryTickets, LotteryTickets.makeAutoTickets(auto));
    }

    public List<Set<Integer>> autoLotteryTickets() {
        return autoLotteryTickets.getLotteryTickets();
    }

    public FinalResult getResult(WinningTicket winningTicket) {
        FinalResult manualResult = manualLotteryTickets.getResult(winningTicket);
        FinalResult autoResult = autoLotteryTickets.getResult(winningTicket);
        return manualResult.plus(autoResult);
    }
}
