package lotto.generator;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualNumberGenerator implements NumberGenerator {

    private String numbers;

    public ManualNumberGenerator(String numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<LottoNumber> generate() {
        String[] splitNumbers = numbers.split(", ");
        return Arrays.stream(splitNumbers)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());
    }
}
