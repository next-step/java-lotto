package step3.lotto.domain;

import step3.lotto.domain.numbers.LottoWinningNumber;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

public class LottoMatch {

    private static LottoWinningNumber lottoWinningNumber;

    private static final int MATCH_LOTTE_MAX_COUNT = 5;
    private static final int MATCH_LOTTE_MIN_COUNT = 1;

    private LottoMatch() {
    }

    public static void playLottoMatch(String WinningNumbers, Set<SortedSet<Integer>> buyLottoHashSet, int bonusNumber) {
        lottoWinningNumber = new LottoWinningNumber(WinningNumbers, bonusNumber);

        Iterator it = buyLottoHashSet.iterator();

        while (it.hasNext()) {
            addWinningCount((SortedSet<Integer>) it.next());
        }
    }

    private static void addWinningCount(SortedSet<Integer> lotto) {
        int rank = lottoWinningNumber.getRank(lotto);

        if (rank >= MATCH_LOTTE_MIN_COUNT && rank <= MATCH_LOTTE_MAX_COUNT) {
            LottoStatusEnum.findByCount(rank).addWinningCount();
        }
    }
}
