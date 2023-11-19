package autolotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGeneratorImpl implements LottoNumberGenerator {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUMBERS_PER_TICKET = 6;
    private final List<Integer> numbers;

    public LottoNumberGeneratorImpl() {
        this.numbers = IntStream.rangeClosed(1, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> targetNumbers = new ArrayList<>(numbers);
        Collections.shuffle(targetNumbers);
        return targetNumbers.stream()
                .limit(NUMBERS_PER_TICKET)
                .sorted()
                .collect(Collectors.toList());
    }
}
