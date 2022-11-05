package lotto.domain;

import lotto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int FIXED_NUMBER_COUNT = 6;
    private final List<LottoNumber> numbers;

    public LottoTicket() {
        this(generate());
    }


    public LottoTicket(final List<LottoNumber> numbers) {
        validateCountOfNumbers(numbers);
        validateDuplicateNumbers(numbers);

        this.numbers = numbers;
    }

    private static List<LottoNumber> generate() {
        List<LottoNumber> shuffledList = LottoNumber.all();
        Collections.shuffle(shuffledList);

        return shuffledList.subList(0, 6).stream()
                .sorted()
                .collect(Collectors.toList());
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

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }
}
