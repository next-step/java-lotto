package lotto.domain;

import java.util.Set;

public class LottoResultNumber {

    private final Number number;

    public LottoResultNumber(Number number) {
        this.number = number;
    }

    public Set<Integer> getNumbers() {
        return number.getNumbers();
    }
}
