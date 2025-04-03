package lotto.domain.product.lotto;

import lotto.domain.Quantity;
import lotto.domain.product.FinalResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryTickets {

    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets() {
        lotteryTickets = new ArrayList<>();
    }

    public void add(LotteryTicket lotteryTicket) {
        lotteryTickets.add(lotteryTicket);
    }

    public List<Set<Integer>>  getLotteryTickets() {
        return lotteryTickets.stream()
                .map(LotteryTicket::getValues)
                .collect(Collectors.toList());
    }

    public FinalResult getResult(WinningTicket winningTicket) {
        FinalResult finalResult = new FinalResult();
        lotteryTickets.forEach(lotteryTicket -> {
            LottoRank rank = winningTicket.getRank(lotteryTicket);
            finalResult.put(rank);
        });
        return finalResult;
    }

    public static LotteryTickets makeAutoTickets(Quantity auto) {
        LotteryTickets lotteryTickets = new LotteryTickets();
        for (int i = 0; i < auto.value(); i++) {
            lotteryTickets.add(new LotteryTicket());
        }
        return lotteryTickets;
    }
}
