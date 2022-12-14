package lotto.domain;

import lotto.strategy.RandomNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Purchasing {

    private static final int LOTTO_PRICE = 1000;

    private static List<Lotto> lottos;
    private static int manualCount;
    private static int randomCount;

    public Purchasing(Money money) {
        lottos = new ArrayList<>();
        manualCount = 0;
        randomCount = money.divideMoney(LOTTO_PRICE);
        addRandomLotto(randomCount);
    }

    public Purchasing(Money money, List<Lotto> manualLottos) {
        lottos = new ArrayList<>(manualLottos);
        manualCount = manualLottos.size();
        randomCount = money.divideMoney(LOTTO_PRICE) - manualCount;
        addRandomLotto(randomCount);
    }

    private void addRandomLotto(int randomCount) {
        for (int i = 0; i < randomCount; i++) {
            lottos.add(new Lotto(new RandomNumberStrategy()));
        }
    }

    public Map<WinningType, Integer> getWinningResult(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.matchWinningLotto(winningLotto))
                .collect(Collectors.toMap(winningType -> winningType, value -> 1, Integer::sum));
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public static int getManualCount() {
        return manualCount;
    }

    public static int getRandomCount() {
        return randomCount;
    }
}
