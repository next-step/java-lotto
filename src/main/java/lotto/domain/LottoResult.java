package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private static final long DEFAULT_PRIZE_COUNT = 0;

    private final MyLottoTickets myLottoTickets;
    private final LottoTicket winnerLottoTicket;
    private final Map<LottoPrize, Long> prizeCount = new EnumMap<>(LottoPrize.class);

    public LottoResult(MyLottoTickets myLottoTickets, LottoTicket winnerLottoTicket) {
        this.myLottoTickets = myLottoTickets;
        this.winnerLottoTicket = winnerLottoTicket;
    }

    public void countPrize() {
        List<LottoPrize> mappedLottoPrizes = myLottoTickets.lottoTickets()
                .stream()
                .map(lottoTicket -> LottoPrize.of(lottoTicket, winnerLottoTicket))
                .collect(Collectors.toList());
        for (LottoPrize keyLottoPrize: LottoPrize.values()) {
            putPrizeCount(mappedLottoPrizes, keyLottoPrize);
        }
    }

    private void putPrizeCount(List<LottoPrize> mappedLottoPrizes, LottoPrize keyLottoPrize) {
        long count = mappedLottoPrizes.stream()
                .filter(prize -> prize == keyLottoPrize)
                .count();
        prizeCount.put(keyLottoPrize, count);
    }

    public long lottoPrizeCount(LottoPrize lottoPrize) {
        return prizeCount.get(lottoPrize);
    }

    public double earningRate() {
        double totalPrizeAmount = prizeCount.entrySet()
                .stream()
                .mapToLong(this::eachPrizeAmount)
                .sum();
        return totalPrizeAmount / myLottoTickets.totalTicketPurchasePrice();
    }

    private long eachPrizeAmount(Map.Entry<LottoPrize, Long> lottoPrizeLongEntry) {
        return lottoPrizeLongEntry.getKey().prizeMoney() * lottoPrizeLongEntry.getValue();
    }
}
