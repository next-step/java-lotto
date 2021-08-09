package lotto.domain;

import lotto.dto.WinStats;

import java.util.*;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoTickets(Money money, List<LottoTicket> lottoTickets, List<LottoTicket> manualNumbers) {
        this.lottoTickets.addAll(manualNumbers);
        this.lottoTickets.addAll(lottoTickets);
        if (money.countLotto() < this.lottoTickets.size()) {
            throw new IllegalArgumentException("로또 구입 금액이 부족합니다.");
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public WinStats getWinStats(WinLotto winLotto, Money money) {
        Map<WinAmount, Integer> matchMap = new HashMap<>();
        long amount = 0;

        for (LottoTicket i : lottoTickets) {
            WinAmount winAmount = i.getWinAmount(winLotto);
            if (winAmount != WinAmount.FAIL) {
                matchMap.put(winAmount, matchMap.getOrDefault(winAmount, 0) + 1);
                amount += winAmount.getReward();
            }
        }

        return new WinStats(matchMap, calculateYield(amount, money));
    }

    private float calculateYield(long amount, Money money) {
        if (amount == 0) {
            return 0;
        }
        return (float) amount / money.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}
