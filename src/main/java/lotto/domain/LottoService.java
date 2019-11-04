package lotto.domain;

import java.util.*;

public class LottoService {

    private static final int LOTTO_AMOUNT = 1000;

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

    public Map<WinnerType, Integer> findWinnerStats(List<Lotto> lottos, Lotto winnerLotto, int bonusNumber) {
        Map<WinnerType, Integer> winnerStat = new HashMap<>();

        for (Lotto lotto : lottos) {
            Optional<WinnerType> winnerType = findWinnerType(lotto, winnerLotto, bonusNumber);
            winnerType.ifPresent(type -> addStat(winnerStat, type));
        }
        return winnerStat;
    }

    private Optional<WinnerType> findWinnerType(Lotto lotto, Lotto winnerLotto, int bonusNumber) {
        int count = 0;
        boolean isMatchBonus = false;
        for (Integer number : lotto.getNumbers()) {
            count = winnerLotto.contains(number) ? count + 1 : count;
            isMatchBonus = (number == bonusNumber) || isMatchBonus;
        }

        return WinnerType.findByCount(count, isMatchBonus);
    }

    private void addStat(Map<WinnerType, Integer> winnerStat, WinnerType winnerType) {
        winnerStat.computeIfPresent(winnerType, (type, count) -> count + 1);
        winnerStat.putIfAbsent(winnerType, 1);
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

}
