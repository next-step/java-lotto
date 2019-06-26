package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int MAX_LOTTO_NUM_COUNT = 6;
    static final int MIN_LOTTO_NUM = 1;
    static final int MAX_LOTTO_NUM = 45;
    static final int AMOUNT = 1000;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
