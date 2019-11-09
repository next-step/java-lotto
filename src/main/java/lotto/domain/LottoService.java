package lotto.domain;

import java.util.*;

public class LottoService {

    private static final int LOTTO_AMOUNT = 1000;

    public int buyTicket(int amount) {
        return amount / LOTTO_AMOUNT;
    }

    public List<Lotto> createLottoTickets(int count, List<Lotto> manualLottos) {
        int autoCount = count - manualLottos.size();
        if (autoCount < 0) {
            throw new IllegalArgumentException("구매금액보다 수동으로 구매한 로또 수가 더 클 수 없습니다.");
        }

        List<Lotto> lottos = new ArrayList<>(manualLottos);
        for (int i = 0; i < autoCount; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    public Map<WinnerType, Integer> findWinnerStats(List<Lotto> lottos, WinnerLotto winnerLotto) {
        Map<WinnerType, Integer> winnerStat = new HashMap<>();

        for (Lotto lotto : lottos) {
            Optional<WinnerType> winnerType = winnerLotto.findWinnerType(lotto);
            winnerType.ifPresent(type -> addStat(winnerStat, type));
        }
        return winnerStat;
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
