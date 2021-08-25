package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ManualNumbersCreator implements LottoNumbersCreator {
    private static final String BLINK = " ";
    private static final String SEPARATOR = ",";
    private List<Integer> numbers;

    public ManualNumbersCreator(String numbers) {
        this.numbers = Arrays.stream(numbers.replaceAll(BLINK, "").split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> createNumbers() {
        Collections.sort(numbers);
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }
}
