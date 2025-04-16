package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final Integer LOTTO_NUMBERS_SIZE = 6;
    private static final Integer LOTTO_NUMBERS_MIN = 1;
    private static final Integer LOTTO_NUMBERS_MAX = 45;
    private final List<Integer> numbers;

    /**
     * 내부 생성자
     */
    public LottoNumbers() {
        this(generateNumbers());
    }

    /**
     * 외부에서 주입받을 경우
     */
    public LottoNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    /**
     * 내부 생성 로직
     */
    public static List<Integer> generateNumbers() {
        // 1부터 45까지의 숫자 생성
        List<Integer> numbers = IntStream.range(LOTTO_NUMBERS_MIN, LOTTO_NUMBERS_MAX)
            .boxed()
            .collect(Collectors.toList());
        // 숫자 셔플
        Collections.shuffle(numbers);

        // 리스트에서 6개 숫자 선택 후 정렬하고 반환
        return numbers.stream()
            .limit(LOTTO_NUMBERS_SIZE)
            .sorted()
            .collect(Collectors.toList());
    }

    /**
     * 외부에서 번호를 주입받을 경우 validation을 거침
     */
    public void validateNumbers(List<Integer> numbers) {
        checkSize(numbers);
        checkRangeAll(numbers);
        checkDuplicateNumbers(numbers);
    }

    /**
     * 사이즈 체크 validation
     */
    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("숫자는 반드시" + LOTTO_NUMBERS_SIZE + "개여야 합니다.");
        }
    }

    /**
     * 중복 validation
     */
    private void checkDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    /**
     * 범위 validation
     */
    private void checkRangeAll(List<Integer> numbers) {
        numbers.forEach(this::checkRange);
    }

    private void checkRange(int number) {
        if (number < LOTTO_NUMBERS_MIN || number > LOTTO_NUMBERS_MAX) {
            throw new IllegalArgumentException("숫자는 " + LOTTO_NUMBERS_MIN + " ~ " + LOTTO_NUMBERS_MAX + " 사이여야 합니다.");
        }
    }

    /**
     * VO를 위한 equals, hashcode -> 계속 정렬 유지
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        LottoNumbers that = (LottoNumbers)o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }

    /**
     * getter 정의
     */
    public int getSize() {
        return numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
