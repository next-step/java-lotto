package lotto.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGeneratorImpl implements NumbersGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final LottoNumbers numbers;

    public RandomNumbersGeneratorImpl() {
        this.numbers = new LottoNumbers(IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }

    @Override
    public List<LottoNumber> generate() {
        Collections.shuffle(this.numbers.getNumberList());
        return Collections.unmodifiableList(
                numbers.getNumberList().stream()
                        .limit(LOTTO_NUMBER_SIZE)
                        .sorted(Comparator.comparingInt(LottoNumber::getValue))
                        .collect(Collectors.toList())
        );
    }
}
