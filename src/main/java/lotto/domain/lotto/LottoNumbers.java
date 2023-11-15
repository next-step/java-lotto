package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {


    public static final int NUMBER_COUNT = 6;

    private static final String NUMBER_COUNT_ERROR_MESSAGE = String.format("로또 번호는 총 %s자리 입니다", NUMBER_COUNT);

    private final List<LottoNumber> numbers;

    private LottoNumbers(List<Integer> numbers) {
        this.numbers = new ArrayList<>(validate(numbers));
    }

    public static LottoNumbers of(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    private List<LottoNumber> validate(List<Integer> numbers) {
        validateCount(numbers);
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    public long match(LottoNumbers jackpot) {
        return jackpot.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public List<LottoNumber> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "numbers=" + numbers +
                '}';
    }
}
