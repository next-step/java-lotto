package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int SIZE = 6;
    private final Set<LottoNumber> numbers;

    private LottoNumbers(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    // LottoFactory에서 사용
    public static LottoNumbers of(Set<LottoNumber> numbers) {
        validateSize(numbers);
        return new LottoNumbers(numbers);
    }

    // 우승 번호 생성 시 사용
    public static LottoNumbers of(List<Integer> numbers) {
        Set<LottoNumber> numberSet = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
        return of(numberSet);
    }

    // 테스트 코드에서 사용
    public static LottoNumbers of(Integer ... numbers) {
        return of(Arrays.asList(numbers));
    }

    private static void validateSize(Set<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("중복되는 숫자가 존재하거나 6개의 숫자로 이루어져있지 않습니다.");
        }
    }

    public Prize matchNumbers(LottoNumbers winningNumbers) {
        long matchCount = winningNumbers.numbers
                .stream()
                .filter(this::containsWinningNumber)
                .count();
        return Prize.valueOfMatchCount(matchCount);
    }

    private boolean containsWinningNumber(LottoNumber number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
