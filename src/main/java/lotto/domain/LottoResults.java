package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class LottoResults {

    private final Map<LottoRank, LottoTicket> ticketsByRank;

    public LottoResults(Map<LottoRank, LottoTicket> ticketsByRank) {
        this.ticketsByRank = Collections.unmodifiableMap(ticketsByRank);
    }

    public static LottoResults of(Map<LottoRank, List<LottoNumbers>> lottoNumbersByRank) {
        Map<LottoRank, LottoTicket> lottoResults = new EnumMap<>(LottoRank.class);

        for (Map.Entry<LottoRank, List<LottoNumbers>> rankAndNumbersEntry : lottoNumbersByRank.entrySet()) {
            lottoResults.put(rankAndNumbersEntry.getKey(), new LottoTicket(rankAndNumbersEntry.getValue()));
        }

        return new LottoResults(lottoResults);
    }

    public int countBy(LottoRank rank) {
        if (Objects.isNull(ticketsByRank.get(rank))) {
            return 0;
        }
        return ticketsByRank.get(rank).size();
    }

    public BigDecimal calculateEarningRate(Money inputMoney, int scale, RoundingMode roundingMode) {
        Money earningTotal = ticketsByRank.entrySet()
                .stream()
                .map(resultMap -> {
                    LottoRank lottoRank = resultMap.getKey();
                    LottoTicket lottoTicket = resultMap.getValue();
                    return lottoRank.calculatePrizeMoney(lottoTicket.size());
                }).reduce(Money::plus)
                .orElse(Money.ZERO);
        return earningTotal.divide(inputMoney, scale, roundingMode);
    }
}
