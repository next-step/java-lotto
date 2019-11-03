package lotto.domain;

import java.util.*;

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

    public Map<WinnerType, Integer> findWinnerStats(List<Lotto> lottos, Lotto winnerLotto) {
        Map<WinnerType, Integer> winnerStat = new HashMap<>();

        for (Lotto lotto : lottos) {
            Optional<WinnerType> winnerType = findWinnerType(lotto, winnerLotto);
            addStat(winnerStat, winnerType);
        }
        return winnerStat;
    }

    public double findYield(Map<WinnerType, Integer> winnerStat, int buyNumbers) {
        double totalPrize = calculateTotalPrize(winnerStat);
        double yield = totalPrize / (buyNumbers * LOTTO_AMOUNT);

        return Math.floor(yield * 100) / 100;
    }

    private int calculateTotalPrize(Map<WinnerType, Integer> winnerStat) {
        int totalPrize = 0;
        for (WinnerType winnerType : winnerStat.keySet()) {
            totalPrize += winnerType.calculatePrize(winnerStat.get(winnerType));
        }
        return totalPrize;
    }

    private void addStat(Map<WinnerType, Integer> winnerStat, Optional<WinnerType> winnerType) {
        if (!winnerType.isPresent()) {
            return;
        }

        winnerStat.computeIfPresent(winnerType.get(), (type, count) -> count + 1);
        winnerStat.putIfAbsent(winnerType.get(), 1);
    }

    private Optional<WinnerType> findWinnerType(Lotto lotto, Lotto winnerLotto) {

        int count = 0;
        for (Integer number : winnerLotto.getNumbers()) {
            count = lotto.contains(number) ? count + 1 : count;
        }

        return WinnerType.findByCount(count);

    }

}
