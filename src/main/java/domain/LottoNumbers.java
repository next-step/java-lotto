package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private int LOTTO_START_NUMBER = 1;
    private int LOTTO_END_NUMBER = 45;

    private List<Integer> numbers;

    public LottoNumbers() {}

    private LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoNumbers from(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    public LottoNumbers createWinningNumbers(String winningNumbers) {
        return new LottoNumbers().from(
                Arrays.stream(winningNumbers.split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );

    }

    public LottoNumbers makeLotto() {
        Collections.shuffle(setDefaultLottoNumbers());
        List<Integer> newNumbers = IntStream
                .range(0, 6)
                .mapToObj(index -> numbers.get(index))
                .collect(Collectors.toList());
        return from(newNumbers);
    }

    private List<Integer> setDefaultLottoNumbers() {
        numbers = new ArrayList<>();
        for(int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            numbers.add(number);
        }
        return numbers;
    }

}
