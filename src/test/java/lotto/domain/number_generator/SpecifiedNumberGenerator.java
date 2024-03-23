package lotto.domain.number_generator;

import java.util.List;

public class SpecifiedNumberGenerator implements NumberGenerateStrategy {


    private final List<Integer> specifiedNumbers;

    public SpecifiedNumberGenerator(List<Integer> specifiedNumbers) {
        this.specifiedNumbers = specifiedNumbers;
    }

    @Override
    public List<Integer> generate() {
        return specifiedNumbers;
    }

}
