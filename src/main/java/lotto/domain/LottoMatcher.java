package lotto.domain;

import java.util.List;

public class LottoMatcher {

    public int getMatchCnt(List<Integer> lottoNumber, List<Integer> winnerNumbers) {
        return (int) lottoNumber.stream()
            .filter(number -> winnerNumbers.contains(number))
            .count();
    }
}
