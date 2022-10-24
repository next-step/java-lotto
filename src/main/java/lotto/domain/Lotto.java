package lotto.domain;

import lotto.strategy.LottoGeneratorStrategy;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int VALID_SIZE = 6;
    private static final String SEPARATOR = ",";
    private static final String INVALID_SIZE_MESSAGE = "로또 번호 1~45 사이 자연수 6개 입력해주세요.";
    private static final String NULL_OR_BLANK_MESSAGE = "빈 문자를 입력하였습니다.";

    private final Set<LottoNumber> numbers;

    public Lotto(LottoGeneratorStrategy lottoGeneratorStrategy) {
        this(lottoGeneratorStrategy.generate());
    }

    public Lotto(String numbers) {
        this(create(numbers));
    }

    public Lotto(Set<LottoNumber> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }


    private static Set<LottoNumber> create(String numbers) {
        if (isNullOrBlank(numbers)) {
            throw new IllegalArgumentException(NULL_OR_BLANK_MESSAGE);
        }
        List<String> values = Arrays.asList(numbers.split(SEPARATOR));
        return values.stream()
                .map(number -> LottoNumber.of(Integer.parseInt(number.trim())))
                .collect(Collectors.toSet());
    }

    public Set<Integer> toIntSet() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public int matches(Lotto lotto) {
        return (int) lotto.numbers
                .stream()
                .filter(numbers::contains)
                .count();
    }

    boolean hasBonus(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private static boolean isNullOrBlank(String numbers) {
        return numbers == null || numbers.isBlank();
    }

    private void validateSize(Set<LottoNumber> numbers) {
        if (numbers.size() != VALID_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }
}
