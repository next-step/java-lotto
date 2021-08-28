package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private static final int GRADE_NUM = 4;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottoList() {
        return lottos;
    }

    public WinningResult checkLottoPrize(List<Integer> winningNums) {
        Integer[] prizeNums = new Integer[GRADE_NUM];
        Arrays.fill(prizeNums, 0);

        for (Lotto lotto : lottos) {
            checkPrize(prizeNums, lotto, winningNums);
        }

        return new WinningResult(Arrays.asList(prizeNums));
    }

    private void checkPrize(Integer[] prizeNums, Lotto lotto, List<Integer> winningNums) {
        int matchingCount = lotto.countMatchingNums(winningNums);

        if (Prize.PRIZE_1ST.matchingCount() == matchingCount) {
            prizeNums[Prize.PRIZE_1ST.index()]++;
        } else if (Prize.PRIZE_2ND.matchingCount() == matchingCount) {
            prizeNums[Prize.PRIZE_2ND.index()]++;
        } else if (Prize.PRIZE_3RD.matchingCount() == matchingCount) {
            prizeNums[Prize.PRIZE_3RD.index()]++;
        } else if (Prize.PRIZE_4TH.matchingCount() == matchingCount) {
            prizeNums[Prize.PRIZE_4TH.index()]++;
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
