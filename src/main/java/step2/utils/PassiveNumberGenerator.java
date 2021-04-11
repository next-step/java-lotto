package step2.utils;

import java.util.List;

public class PassiveNumberGenerator implements LottoNumberGenerator {

    private final List<Integer> numbers;

    public PassiveNumberGenerator(List<Integer> numbers){
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}
