package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = createLottoNumber();
    }

    private List<Integer> createLottoNumber() {
        List<Integer> numbers = lottoNumberLoop();
        Collections.shuffle(numbers);
        Collections.sort(numbers.subList(0, 6));
        return numbers.subList(0, 6);
    }

    private static List<Integer> lottoNumberLoop() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}