package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottoList() {
        return lottos;
    }

    public WinningResult checkLottoPrize(List<Integer> winningNums) {
        Integer[] prizeNums = new Integer[Prize.values().length];
        Arrays.fill(prizeNums, 0);

        for (Lotto lotto : lottos) {
            checkPrize(prizeNums, lotto, winningNums);
        }

        return new WinningResult(Arrays.asList(prizeNums));
    }

    private void checkPrize(Integer[] prizeNums, Lotto lotto, List<Integer> winningNums) {
        int matchingCount = lotto.countMatchingNums(winningNums);

        if (Prize.FIRST.matchingCount() == matchingCount) {
            prizeNums[Prize.FIRST.index()]++;
        } else if (Prize.SECOND.matchingCount() == matchingCount) {
            prizeNums[Prize.SECOND.index()]++;
        } else if (Prize.THIRD.matchingCount() == matchingCount) {
            prizeNums[Prize.THIRD.index()]++;
        } else if (Prize.FOURTH.matchingCount() == matchingCount) {
            prizeNums[Prize.FOURTH.index()]++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

}
