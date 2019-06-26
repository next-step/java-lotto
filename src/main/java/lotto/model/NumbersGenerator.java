package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersGenerator {

    private List<Integer> numbers;

    public NumbersGenerator() {
        numbers = IntStream.rangeClosed(LottoNumbers.MIN, LottoNumbers.MAX)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> autoGenerate() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(LottoNumbers.LOTTO_NUMBER_SIZE)
                .collect(Collectors.toList());
   }
}
