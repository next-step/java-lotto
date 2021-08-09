package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class Lotto {
    static final int NUMBER_COUNT = 6;
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String COMMA = ",";
    private static final String ONE_BLANK_SPACE = " ";
    private static final String RIGHT_SQUARE_BRACKET = "]";

    private final List<LottoNumber> numbers;

    public Lotto(LottoNumberGeneratingStrategy lottoNumberGeneratingStrategy) {
        List<LottoNumber> numbers = lottoNumberGeneratingStrategy.generateNumbers();

        validateCount(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    Lotto(List<Integer> givenNumbers) {
        List<LottoNumber> numbers = givenNumbers.stream()
                .map(LottoNumber::valueOf)
                .collect(toList());

        validateCount(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<LottoNumber> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개 이어야 합니다.", NUMBER_COUNT));
        }
    }

    private void validateUnique(List<LottoNumber> numbers) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() > uniqueNumbers.size()) {
            throw new IllegalArgumentException("로또 번호가 중복 되었습니다.");
        }
    }

    List<LottoNumber> getNumbers() {
        return numbers;
    }

    int findMatchedNumberCount(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(numbers::contains)
                .count();
    }

    boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LEFT_SQUARE_BRACKET);
        for (LottoNumber number : numbers) {
            stringBuilder.append(number);
            stringBuilder.append(COMMA);
            stringBuilder.append(ONE_BLANK_SPACE);
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(COMMA));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(ONE_BLANK_SPACE));
        stringBuilder.append(RIGHT_SQUARE_BRACKET);
        return stringBuilder.toString();
    }
}
