package lotto.domain;

import java.util.List;

public class LottoMatcher {
    // DONE: getMatCnt 를 원시타입 포장 클래스인 LottoNumber 와 호환되도록 변경해야 함.
    public static int getMatchCnt(List<LottoNumber> lottoNumber, WinnerLotto winnerNumbers) {
        return (int) lottoNumber.stream()
            .filter(number -> winnerNumbers.getNumbers().contains(number))
            .count();
    }
}
