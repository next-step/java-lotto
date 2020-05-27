package lotto;

import java.util.List;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int COUNT_OF_NUMBERS = 6;

    private List<Integer> numbers;

    public Lotto(LottoNumberSelectRule numberSelectRule) {
        this.numbers = numberSelectRule.select();

        if (this.numbers.size() != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자의 개수가 일치하지 않습니다");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
