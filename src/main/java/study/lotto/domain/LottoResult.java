package study.lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private Map<LottoRank, List<LottoTicket>> winners;

    public LottoResult() {
        setWinners();
    }

    private void setWinners() {
        this.winners = new HashMap<>();
        this.winners.put(LottoRank.FIRST, new ArrayList<>());
        this.winners.put(LottoRank.SECOND, new ArrayList<>());
        this.winners.put(LottoRank.THIRD, new ArrayList<>());
        this.winners.put(LottoRank.FOURTH, new ArrayList<>());
    }

    public void addWinner(LottoRank lottoRank, LottoTicket lottoTicket) {
        this.winners.get(lottoRank).add(lottoTicket);
    }

    public List<LottoTicket> getWinner(LottoRank lottoRank) {
        return winners.get(lottoRank).stream()
                .map(LottoTicket::clone)
                .collect(Collectors.toList());
    }
}
