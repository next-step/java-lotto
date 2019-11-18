package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinningLotto {

    private static final int ZERO = 0;
    private static final int HIT_COUNT = 1;

    private List<Integer> winLotto;

    public WinningLotto(int[] winLotto) {
        this.winLotto = wrapWinLotto(winLotto);
    }

    private List<Integer> wrapWinLotto(int[] winLotto) {
        return IntStream.of(winLotto)
                .boxed()
                .collect(Collectors.toList());
    }

    public int checkWinNumber(Lotto lotto) {
        int hitCount = ZERO;
        for (int lottoNo : this.winLotto) {
            hitCount += getHitCount(lottoNo, lotto);
        }
        return hitCount;
    }

    private int getHitCount(int winLottoNumber, Lotto lotto) {
        if (lotto.isContainsWinNumber(winLottoNumber)) {
            return HIT_COUNT;
        } else return ZERO;
    }

}
