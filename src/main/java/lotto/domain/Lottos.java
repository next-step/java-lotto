package lotto.domain;

import java.util.*;

public class Lottos {
    public static final int LOTTO_PRICE_PER_ONE = 1000;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    static Lottos supplyLottos(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos buyLottos(List<Lotto> manualLottos, int price) {
        final List<Lotto> lottos = new ArrayList<>(manualLottos);
        int count = countOfLottos(price) - manualLottos.size();
        while (count > 0) {
            lottos.add(LottoFactory.createLottoAutomatically());
            count--;
        }

        return Lottos.supplyLottos(lottos);
    }

    public static int countOfLottos(int price) {
        return price / LOTTO_PRICE_PER_ONE;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoWinner calculateWinner(LottoWinningCondition winningCondition) {
        final Map<LottoWinnerType, Integer> winners = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoWinnerType winnerType = lotto.winLotto(winningCondition);
            int countOfWinners = winners.get(winnerType) != null ? winners.get(winnerType) : 0;
            winners.put(winnerType, countOfWinners + 1);
        }

        return new LottoWinner(winners);
    }
}
