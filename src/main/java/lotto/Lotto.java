package lotto;

import java.util.List;

public class Lotto {

    public WonCount countWonNumbers(List<Integer> generateLottoNumber, List<Integer> lastWonLottoNumbers) {
        WonCount wonCount = new WonCount();
        for (int oneLottoNumber : generateLottoNumber) {
            wonCount.updateCount(isSameNumber(oneLottoNumber, lastWonLottoNumbers));
        }
        return wonCount;
    }

    private boolean isSameNumber(int oneLottoNumber, List<Integer> lastWonLottoNumbers) {
        return lastWonLottoNumbers.contains(oneLottoNumber);
    }
}
