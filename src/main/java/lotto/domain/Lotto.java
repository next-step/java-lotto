package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    public static final int NUMBERS_SIZE = 6;
    public static final int PRICE = 1000;

    private final List<LottoNumber> numbers;

    public Lotto(int... numbers) {
        this(Arrays.stream(numbers).boxed().toList());
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = toLottoNumbers(numbers);
    }

    private static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
        validateNumbersCount(lottoNumbers);
        validateNoDuplicates(lottoNumbers);
        return lottoNumbers;
    }

    private static void validateNumbersCount(List<LottoNumber> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new RuntimeException("로또 번호 개수가 올바르지 않습니다.");
        }
    }

    private static void validateNoDuplicates(List<LottoNumber> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new RuntimeException("중복된 수를 가질 수 없습니다.");
        }
    }

    public int matchCount(Lotto other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    public Prize rank(Lotto other) {
        return Prize.from(matchCount(other));
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
