package lotto.domain.product;

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

    public FinalResult getResult(LotteryTicket winningTicket) {
        FinalResult finalResult = new FinalResult();
        lotteryTickets.forEach(lotteryTicket -> {
            Integer result = lotteryTicket.getResultBy(winningTicket);
            finalResult.put(result);
        });
        return finalResult;
    }

    public static LotteryTickets makeAutoTickets(Integer count) {
        LotteryTickets lotteryTickets = new LotteryTickets();
        for (int i = 0; i < count; i++) {
            lotteryTickets.add(new LotteryTicket());
        }
        return lotteryTickets;
    }
}
