package lotto;

import java.util.List;

public class Lotto {

    public static final int PRICE = 1000;

    private List<Integer> numbers;

    public Lotto(LottoNumberSelectRule numberGenerateRule) {
        this.numbers = numberGenerateRule.select();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
