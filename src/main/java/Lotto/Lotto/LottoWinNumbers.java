package Lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinNumbers {
    private static final String SPLITTER = ",";

    final List<Integer> numbers;

    public LottoWinNumbers(String numbers) {
        this.numbers = Arrays.stream(numbers.split(SPLITTER))
                .map(str -> Integer.parseInt(str.trim()))
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
