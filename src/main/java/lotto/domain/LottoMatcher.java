package lotto.domain;

import java.util.List;

public class LottoMatcher {
    //TODO: getMatCnt 를 원시타입 포장 클래스인 LottoNumber 와 호환되도록 변경해야 함.
    public int getMatchCnt(List<Integer> lottoNumber, List<Integer> winnerNumbers) {
        return (int) lottoNumber.stream()
            .filter(number -> winnerNumbers.contains(number))
            .count();
    }
}
