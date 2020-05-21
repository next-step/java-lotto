package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoNumberResult {
    private final List<Integer> lottoNumber;

    public LottoNumberResult(List<Integer> lottoNumber) {
        this.lottoNumber = Collections.unmodifiableList(lottoNumber);
    }

    public int calculateMatchCount(List<Integer> winnerNumbers) {
        return (int) winnerNumbers.stream()
                .filter(winnerNumber -> lottoNumber.contains(winnerNumber))
                .count();
    }

    public String toString() {
        return lottoNumber.toString();
    }
}
