package lotto.domain.number;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final int LOTTO_NUMBER_UNDER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = IntStream.rangeClosed(LOTTO_NUMBER_UNDER_BOUND, LOTTO_NUMBER_UPPER_BOUND)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private LottoNumberGenerator() {
    }

    public static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(lottoNumbers);

        return lottoNumbers.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }

    public static LottoNumber findByNumber(int number) {
        return lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1 ~ 45 사이의 값이 아닙니다."));
    }

    public static List<LottoNumber> findAllByNumbers(List<Integer> numbers) {
        validateSizeOfNumbers(numbers);
        validateDuplicateNumber(numbers);

        return numbers.stream()
                .map(LottoNumberGenerator::findByNumber)
                .collect(Collectors.toList());
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> duplicateNumbers = new HashSet<>(numbers);

        if (duplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("번호는 중복될 수 없습니다.");
        }

    }

    private static void validateSizeOfNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("번호의 갯수가 6이 아닙니다.");
        }
    }
}
