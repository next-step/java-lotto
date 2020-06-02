package me.daeho.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final String NUMBER_DELIMITER = ", ";
    private static final int NUMBER_COUNT = 6;

    private final Set<LottoNumber> numbers;

    private LottoTicket(List<LottoNumber> numbers) {
        validNull(numbers);
        this.numbers = new HashSet<>(NUMBER_COUNT);
        this.numbers.addAll(numbers);
        validateNumberSize(this.numbers);
    }

    private void validNull(List<LottoNumber> numbers) {
        if(numbers == null)
            throw new IllegalArgumentException("올바르지 않은 로또 번호 입니다.");
    }

    private void validateNumberSize(Set<LottoNumber> numbers) {
        if (numbers.size() != NUMBER_COUNT)
            throw new IllegalArgumentException(numbers.size() + "는 올바르지 않은 로또 번호 갯수입니다.");
    }

    public static LottoTicket issue(List<LottoNumber> numbers) {
        return new LottoTicket(numbers);
    }

    public int containsCount(LottoNumber ... checkNumbers) {
        return containsCount(Arrays.asList(checkNumbers));
    }

    public int containsCount(List<LottoNumber> checkNumbers) {
        return (int) checkNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.stream().map(LottoNumber::toString).collect(Collectors.joining(NUMBER_DELIMITER));
    }
}
