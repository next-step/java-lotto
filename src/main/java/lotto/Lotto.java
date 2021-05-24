package lotto;

import java.util.List;

public class Lotto {

    public WonCount countWonNumbers(List<Integer> generateLottoNumber, LastWonLottoNumber lastWonLottoNumber) {
        WonCount wonCount = new WonCount();
        for (int oneLottoNumber : generateLottoNumber) {
            wonCount.updateCount(isSameNumber(oneLottoNumber, lastWonLottoNumber));
        }
        return wonCount;
    }

    private SameNumberStateEnum isSameNumber(int oneLottoNumber, LastWonLottoNumber lastWonLottoNumber) {
        if (lastWonLottoNumber.containsMain(oneLottoNumber))
            return SameNumberStateEnum.SAME_MAIN_NUMBER;

        if (lastWonLottoNumber.containsBonus(oneLottoNumber))
            return SameNumberStateEnum.SAME_BONUS_NUMBER;

        return SameNumberStateEnum.NO_SAME;
    }
}
