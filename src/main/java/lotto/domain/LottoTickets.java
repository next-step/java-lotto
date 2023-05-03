package lotto.domain;

import lotto.domain.strategy.LottoTicketsCreateStrategy;
import lotto.dto.WinningResult;
import lotto.enums.Rank;

import java.util.*;

public class LottoTickets {

    private final int TICKET_PRICE = 1000;
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(LottoTicketsCreateStrategy createStrategy) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (List<Integer> numbers : createStrategy.getLottoNumbers()) {
            lottoTickets.add(new LottoTicket(numbers));
        }
        return new LottoTickets(lottoTickets);
    }

    public double getTotalReturn(List<Integer> winningNumbers, int bonusBall) {
        double totalPrize = lottoTickets.stream().mapToInt(o -> o.getRank(winningNumbers, bonusBall).getPrize()).sum();
        double purchaseAmount = lottoTickets.size() * TICKET_PRICE;
        return convertTotalReturnFormat(totalPrize / purchaseAmount);
    }

    public double convertTotalReturnFormat(double totalReturn) {
        return Math.floor(totalReturn * 100) / 100.0;
    }

    public WinningResult tallyUp(List<Integer> winningNumbers, int bonusBall) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            Rank rank = lottoTicket.getRank(winningNumbers, bonusBall);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return new WinningResult(rankCount, getTotalReturn(winningNumbers, bonusBall));
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public void addTickets(LottoTickets tickets) {
        this.lottoTickets.addAll(tickets.lottoTickets);
    }

}
