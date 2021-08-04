package lotto.domain;

import lotto.dto.WinStats;

import java.util.*;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;
    private Money money;

    public LottoTickets(Money money, LottoNumbers lottoNumbers) {
        int size = money.countLotto();
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoTickets.add(new LottoTicket(lottoNumbers));
        }
        this.lottoTickets = lottoTickets;
        this.money = money;
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public WinStats getWinStats(LottoNumbers winNumbers) {
        Map<WinAmount, Integer> matchMap = new HashMap<>();
        long amount = 0;

        for (LottoTicket i : lottoTickets) {
            WinAmount winAmount = i.getWinAmount(winNumbers);
            if (winAmount != WinAmount.FAIL) {
                matchMap.put(winAmount, matchMap.getOrDefault(winAmount, 0) + 1);
                amount += winAmount.getReward();
            }
        }

        return new WinStats(matchMap, calculateYield(amount));
    }

    private float calculateYield(long amount) {
        if (amount == 0) {
            return 0;
        }
        return (float) amount / money.getValue();
    }
}
