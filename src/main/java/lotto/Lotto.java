package lotto;

import java.util.List;

public class Lotto {

    public static final int PRICE = 1000;

    private List<Integer> numbers;

    public Lotto(LottoNumberSelectRule numberSelectRule) {
        this.numbers = numberSelectRule.select();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
