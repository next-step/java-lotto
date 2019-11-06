package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumbers.*;

public class LottoNumberProvider {

    private static final List<Integer> numbers = new ArrayList<>();

    private static List<Integer> getNumbers() {
        if (numbers.isEmpty()) {
            for (int i = 1; i <= MAX_NUMBER; i++) {
                numbers.add(i);
            }
        }

        return numbers;
    }

    private static List<Integer> getShuffledNumbers() {
        List<Integer> shuffledNumbers = LottoNumberProvider.getNumbers();
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers;
    }

    public static LottoNumbers createLottoNumber() {
        List<Integer> shuffledNumbers = getShuffledNumbers();
        List<Integer> numbers = shuffledNumbers.stream()
                .limit(NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toList());

        return new LottoNumbers(numbers, shuffledNumbers.get(shuffledNumbers.size() - 1));
    }
}
