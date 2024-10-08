package lotto.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LIMIT_LOTTO_NUMBER = 45;
    private static final int LIMIT_LOTTO_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers){
        this.numbers = numbers;
        LottoValidator.validate(numbers);
    }

    public static Lotto create(){
        List<Integer> numbers = createRandomNumbers();
        return new Lotto(numbers);
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < LIMIT_LOTTO_NUMBER; i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, LIMIT_LOTTO_COUNT);
    }

    public boolean hasNumber(Integer winningNumber) {
        return this.numbers.contains(winningNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
