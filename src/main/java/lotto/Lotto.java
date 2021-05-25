package lotto;

import java.util.List;

public class Lotto {

    public SameNumberCountInALotto countWonNumbers(List<Integer> generateLottoNumber, LastWonLottoNumber lastWonLottoNumber) {
        SameNumberCountInALotto sameNumberCountInALotto = new SameNumberCountInALotto();
        for (int oneLottoNumber : generateLottoNumber) {
            sameNumberCountInALotto.updateCount(isSameNumber(oneLottoNumber, lastWonLottoNumber));
        }
        return sameNumberCountInALotto;
    }

    private SameNumberStateEnum isSameNumber(int oneLottoNumber, LastWonLottoNumber lastWonLottoNumber) {
        if (lastWonLottoNumber.containsMain(oneLottoNumber))
            return SameNumberStateEnum.SAME_MAIN_NUMBER;

        if (lastWonLottoNumber.containsBonus(oneLottoNumber))
            return SameNumberStateEnum.SAME_BONUS_NUMBER;

        return SameNumberStateEnum.NO_SAME;
    }
}
