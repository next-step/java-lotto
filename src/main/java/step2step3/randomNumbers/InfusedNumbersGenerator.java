package step2step3.randomNumbers;

import step2step3.lotto.lottoNumber.NumbersGenerator;

import java.util.Set;

public class InfusedNumbersGenerator implements NumbersGenerator {

    private final Set<Integer> numbers;

    public InfusedNumbersGenerator(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Set<Integer> numbers() {
        return numbers;
    }

}
