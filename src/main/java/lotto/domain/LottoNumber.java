package lotto.domain;

import java.util.Set;

public class LottoNumber {

    private final Number number;

    public LottoNumber(Number number) {
        this.number = number;
    }

    public Set<Integer> getNumbers() {
        return number.getNumbers();
    }
}
