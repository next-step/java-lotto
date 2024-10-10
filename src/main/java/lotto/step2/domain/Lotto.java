package lotto.step2.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers){
        this.numbers = numbers;
        LottoValidator.validate(numbers);
    }

    public static Lotto create(LottoNumbersGenerater generater){
        return new Lotto(generater.generate());
    }

    public boolean hasNumber(Integer winningNumber) {
        return this.numbers.contains(winningNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
