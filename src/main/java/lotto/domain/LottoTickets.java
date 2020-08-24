package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;
    private final BigDecimal purchasePrice;

    public LottoTickets(List<LottoTicket> lottoTickets, int purchasePrice) {
        this.lottoTickets = lottoTickets;
        this.purchasePrice = BigDecimal.valueOf(purchasePrice);
    }

    public int size() {
        return lottoTickets.size();
    }

    public LottoResult getMatchResult(WinningCondition winningCondition) {
        Map<Rank, Integer> matchResult = new EnumMap<>(Rank.class);
        lottoTickets.forEach(ticket -> {
            Rank rank = winningCondition.getRank(ticket);
            matchResult.put(rank, matchResult.getOrDefault(rank, 0) + 1);
        });

        return new LottoResult(matchResult);
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public List<String> getLottoTicketStrings() {
        return lottoTickets.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.toList());
    }
}
