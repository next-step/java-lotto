package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StatisticsReport {

    private final LottoWallet lottoWallet;
    private final WinningLotto winningLotto;
    private Map<LottoRank, Long> prizeMap;

    private StatisticsReport(LottoWallet lottoWallet, WinningLotto winningLotto) {
        this.lottoWallet = lottoWallet;
        this.winningLotto = winningLotto;
    }

    public static StatisticsReport from(LottoWallet lottoWallet, WinningLotto winningLotto) {
        return new StatisticsReport(lottoWallet, winningLotto);
    }

    public BigDecimal rate() {
        int totalPurchasePrice = LottoShop.LOTTO_PRICE * this.lottoWallet.totalTicketCount();
        return BigDecimal.valueOf(totalPrize())
            .divide(BigDecimal.valueOf(totalPurchasePrice), 2, RoundingMode.HALF_UP)
            .stripTrailingZeros();
    }

    public long totalPrize() {
        return prizeMap().keySet().stream()
            .filter(lottoRank -> prizeMap.get(lottoRank) > 0)
            .mapToLong(LottoRank::prize)
            .sum();
    }

    public long count(LottoRank prize) {
        return prizeMap().getOrDefault(prize, 0L);
    }

    private Map<LottoRank, Long> prizeMap() {
        if (prizeMap != null) {
            return prizeMap;
        }

        return prizeMap = IntStream.range(0, lottoWallet.totalTicketCount()).mapToObj(
                i -> LottoRank.prizeByMatchedCount(winningLotto.compare(lottoWallet.oneTicket(i)),
                    winningLotto.compareBonus(lottoWallet.oneTicket(i))))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
