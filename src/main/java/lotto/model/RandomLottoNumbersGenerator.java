package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumbersGenerator implements LottoNumbersGenerator {
    @Override
    public LottoNumbers generate() {
        List<Integer> numbers = IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER + 1).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);

        return new LottoNumbers(numbers.subList(0, Lotto.LOTTO_NUMBER_SIZE));
    }
}
