package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StatisticsReport {

    private final LottoWallet lottoWallet;
    private final Map<LottoRank, Integer> prizeMap;

    private StatisticsReport(LottoWallet lottoWallet) {
        this.lottoWallet = lottoWallet;
        this.prizeMap = initializationMap();
    }

    public static StatisticsReport of(LottoWallet lottoWallet) {
        return new StatisticsReport(lottoWallet);
    }

    private static Map<LottoRank, Integer> initializationMap() {
        return Arrays.stream(LottoRank.values())
            .collect(Collectors.toMap(prize -> prize, prize -> 0));
    }

    public StatisticsReport report(WinningLotto winningLotto) {
        lottoNumberJudge(winningLotto);
        return this;
    }

    private void lottoNumberJudge(WinningLotto winningLotto) {
        IntStream.range(0, lottoWallet.totalTicketCount())
            .mapToObj(
                i -> LottoRank.prizeByMatchedCount(winningLotto.compare(lottoWallet.oneTicket(i)),
                    winningLotto.compareBonus(lottoWallet.oneTicket(i))))
            .filter(Objects::nonNull)
            .forEach(prize -> {
                this.prizeMap.put(prize, prizeMap.get(prize) + 1);
            });
    }

    public BigDecimal rate() {
        int totalPurchasePrice = 1000 * this.lottoWallet.totalTicketCount();
        return BigDecimal.valueOf(totalPrize())
            .divide(BigDecimal.valueOf(totalPurchasePrice), 2, RoundingMode.HALF_UP)
            .stripTrailingZeros();
    }

    public int totalPrize() {
        return prizeMap.keySet().stream().mapToInt(prize -> {
            if (0 < prizeMap.get(prize)) {
                return prize.prize();
            }
            return 0;
        }).sum();
    }

    public int count(LottoRank prize) {
        return prizeMap.get(prize);
    }
}
