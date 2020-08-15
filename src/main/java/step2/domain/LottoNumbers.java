package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 로또 번호 목록 (일급 컬렉션)
 */
public class LottoNumbers {

    /**
     * 번호 갯수
     */
    public static final int SIZE = 6;

    private final List<LottoNumber> numbers;

    /**
     * 생성자를 통해 초기화한다.
     *
     * @param numbers
     */
    public LottoNumbers(final List<Integer> numbers) {
        if (SIZE != numbers.size())
            throw new IllegalArgumentException("숫자 목록의 갯수는 6개 입니다.");

        this.numbers = toNumbers(numbers);
    }

    /**
     * List<Integer> 를 List<LottoNumber> 로 변환하여 반환한다.
     *
     * @param numbers
     * @return
     */
    private static List<LottoNumber> toNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    /**
     * 숫자 목록과 비교하여 일치하는 횟수를 반환한다.
     *
     * @param numbers
     * @return
     */
    public long matchCount(final List<Integer> numbers) {
        return this.numbers.stream()
                .filter(LottoNumbers.toNumbers(numbers)::contains)
                .count();
    }

    /**
     * 숫자 목록과 비교하여 일치여부를 판별한다.
     *
     * @param numbers
     * @return
     */
    public boolean compare(final List<Integer> numbers) {
        return this.numbers.equals(toNumbers(numbers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.numbers.toArray());
    }
}
