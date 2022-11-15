package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int FIXED_NUMBER_COUNT = 6;
    private final List<LottoNumber> numbers;

    private LottoTicket(final List<LottoNumber> numbers) {
        validateCountOfNumbers(numbers);
        validateDuplicateNumbers(numbers);

        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    public static LottoTicket create() {
        return new LottoTicket(generate());
    }

    public static LottoTicket create(List<LottoNumber> numbers) {
        return new LottoTicket(numbers);
    }

    public static LottoTicket createFromIntegerList(List<Integer> numbers) {
        return new LottoTicket(numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    private static List<LottoNumber> generate() {
        List<LottoNumber> shuffledList = LottoNumber.all();
        Collections.shuffle(shuffledList);

        return shuffledList.subList(0, 6).stream().collect(Collectors.toList());
    }

    private void validateCountOfNumbers(final List<LottoNumber> numbers) {
        if (numbers.size() != FIXED_NUMBER_COUNT) {
            throw new IllegalArgumentException(FIXED_NUMBER_COUNT + "개의 숫자를 입력하세요");
        }
    }

    private void validateDuplicateNumbers(final List<LottoNumber> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자는 입력 불가능합니다");
        }
    }

    public int getTheNumberOfCommonNumbers(final LottoTicket winningTicket) {
        return (int) numbers.stream()
                .filter(winningTicket.numbers::contains)
                .count();
    }

    public boolean hasNumber(final LottoNumber bonus) {
        return numbers.contains(bonus);
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
