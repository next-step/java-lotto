package step5.domain;

import java.util.*;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;
    private Map<Rank, Integer> result = new LinkedHashMap<>();

    public LottoTickets() {
        lottoTickets = new ArrayList<>();
    }

    public void match(WinningLottoTicket winningLottoTicket, BonusBall bonusBall) {
        Arrays.asList(Rank.values())
                .forEach(rank -> result.put(rank, 0));

        for (LottoTicket lottoTicket : lottoTickets) {
            Integer matchNumber = lottoTicket.matchWinningLotto(winningLottoTicket);
            boolean isMatched = lottoTicket.matchBonusBall(bonusBall);
            Rank rank = Rank.valueOf(matchNumber, isMatched);
            result.put(rank, result.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> result() {
        return result;
    }

    public void buyLottoAutomatically(int num) {
        for (int i = 0; i < num; i++) {
            AutoLottoTicket autoLottoTicket = new AutoLottoTicket();
            lottoTickets.add(autoLottoTicket);
        }
    }

    public void buyLottoManually(ManualLottoTicket manualLottoTicket) {
        lottoTickets.add(manualLottoTicket);
    }

    public List<LottoTicket> tickets() {
        return lottoTickets;
    }
}
