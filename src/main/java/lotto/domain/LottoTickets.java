package lotto.domain;

import lotto.dto.WinningResult;
import lotto.enums.Rank;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTickets {

    private final int TICKET_PRICE = 1000;
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public double getTotalReturn(List<Integer> winLottoNumbers) {
        double totalPrize = lottoTickets.stream().mapToInt(o -> o.getRank(winLottoNumbers).getPrize()).sum();
        double purchaseAmount = lottoTickets.size() * TICKET_PRICE;
        return convertTotalReturnFormat(totalPrize / purchaseAmount);
    }

    public double convertTotalReturnFormat(double totalReturn) {
        return Math.floor(totalReturn * 100) / 100.0;
    }

    public WinningResult tallyUp(List<Integer> winLottoNumbers) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            Rank rank = lottoTicket.getRank(winLottoNumbers);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return new WinningResult(rankCount, getTotalReturn(winLottoNumbers));
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public String lottoTicketsToString() {
        return lottoTickets.stream().map(o -> o.toString()).collect(Collectors.joining("\n"));
    }
}
