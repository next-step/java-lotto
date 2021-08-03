package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {
    private final List<Lotto> lottos;
    private Lotto previousLotto;

    public Game(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setPreviousLotto(Lotto previousLotto) {
        this.previousLotto = previousLotto;
    }

    public int countSameNumber(int sameNumberCount) {
        return (int) lottos.stream()
                .filter(lotto -> lotto.hasSameNumberCount(previousLotto, sameNumberCount))
                .count();
    }

    public String getYield() {
        long totalWinMoney = Arrays.stream(Reward.values())
                .map(reward -> countSameNumber(reward.getRightNumberCount()) * reward.getMoney())
                .mapToLong(Long::valueOf)
                .sum();

        return String.format("%.2f", totalWinMoney / (lottos.size() * LottoMachine.LOTTO_PRICE * 1f) - 0.005f);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
