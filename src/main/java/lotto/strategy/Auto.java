package lotto.strategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Auto implements Numbers {
    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(MIN_NUMBER, MAX_NUMBER)
                                                            .boxed()
                                                            .collect(Collectors.toList());

    private final List<Integer> lottoNumber;

    public Auto() {
        this.lottoNumber = createLottoNumbers();
    }

    public Auto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = LOTTO_NUMBERS;

        Collections.shuffle(numbers);

        List<Integer> result = numbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());

        Collections.sort(result);

        return result;
    }

    @Override
    public List<Integer> readOnlyNumbers() {
        return Collections.unmodifiableList(lottoNumber);
    }

    @Override
    public boolean checkNumbers(List<Integer> numbers) {
        return Objects.equals(numbers, lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
