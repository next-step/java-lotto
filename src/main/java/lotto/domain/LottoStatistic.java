package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistic {

    private final long totalAmount;

    private final Map<LottoRank, Integer> lottoRankMatch;

    private final String aggregationOfReturn;

    public LottoStatistic(List<LottoTicket> lottoTickets, WinningLottoTicket winningLottoTicket, int buyPrice){
        // 각 당첨등수 셋팅
        lottoTickets.stream()
                .forEach(value -> value.setLottoRank(winningLottoTicket.getWinnerLotto(value)));

        this.totalAmount = getAmountStatistics(lottoTickets);
        this.aggregationOfReturn = getAggregationOfReturns(totalAmount, buyPrice);
        this.lottoRankMatch = initLottoRank(lottoTickets);
    }

    private Map<LottoRank, Integer> initLottoRank(List<LottoTicket> lottoTickets) {
        Map<LottoRank, Integer> lottoRankMatch = new HashMap<>();

        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.NOTTING_PLACE).forEach(
                    lottoRank -> lottoRankMatch.put(lottoRank, lottoRankMatchCount(lottoTickets, lottoRank))
                );

        return lottoRankMatch;
    }


    private static String getAggregationOfReturns(long totalAmount, int buyPrice) {
        BigDecimal totolAmount = new BigDecimal(totalAmount);

        BigDecimal buyLottoPrice = new BigDecimal(buyPrice);

        return totolAmount.divide(buyLottoPrice, 3, RoundingMode.HALF_UP).toString();
    }

    private static long getAmountStatistics(List<LottoTicket> lottoTickets) {
        return lottoTickets.stream()
                .map(LottoTicket::getLottoRank)
                .mapToInt(v -> v.winningAmount)
                .sum();
    }

    private static int lottoRankMatchCount(List<LottoTicket> lottoTickets, LottoRank lottoRank) {
        return (int) lottoTickets.stream()
                .filter(lottoTicket -> lottoTicket.getLottoRank() == lottoRank)
                .count();
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public Integer getLottoRankMatchCount(LottoRank lottoRank) {
        return lottoRankMatch.get(lottoRank);
    }

    public String getAggregationOfReturn() {
        return aggregationOfReturn;
    }
}
