package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    private static final int LOTTO_AMOUNT = 1000;
    private static final int WIN_MIN_NUMBER = 3;

    public int buyTicket(int amount) {
        return amount / LOTTO_AMOUNT;
    }

    public List<Lotto> createLottoTickets(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    public Map<Integer, Integer> findWinnerStats(List<Lotto> lottos, Lotto winnerLotto) {
        Map<Integer, Integer> winnerStat = new HashMap<>();

        for (Lotto lotto : lottos) {
            int sameNumber = findSameNumber(lotto, winnerLotto);
            addStat(winnerStat, sameNumber);
        }
        return winnerStat;
    }

    private void addStat(Map<Integer, Integer> winnerStat, int sameNumber) {
        if(sameNumber == 0) {
            return;
        }

        winnerStat.computeIfPresent(sameNumber, Integer::sum);
        winnerStat.putIfAbsent(sameNumber, 1);
    }

    private int findSameNumber(Lotto lotto, Lotto winnerLotto) {

        int count = 0;
        for (Integer number : winnerLotto.getNumbers()) {
            count = lotto.contains(number) ? count+1 : count;
        }

        if (count < WIN_MIN_NUMBER) {
            return 0;
        }

        return count;
    }

}
