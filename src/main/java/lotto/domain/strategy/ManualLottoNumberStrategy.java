package lotto.domain.strategy;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumberStrategy implements LottoNumberStrategy {

    private static final String COMMA_BLANK = ", ";

    private final List<Integer> numbers;

    public ManualLottoNumberStrategy(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(COMMA_BLANK)) {
            numbers.add(Integer.valueOf(number));
        }
        this.numbers = numbers;
    }

    @Override
    public List<LottoNumber> create() {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

}
