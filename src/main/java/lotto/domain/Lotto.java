package lotto.domain;

import lotto.common.exception.LottoServiceException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Lotto {

    private Set<Integer> numbers;

    private Lotto(Set<Integer> numbers) {
        validateNumbers(numbers);
        validateSize(numbers);
        this.numbers = numbers;
    }

    static Lotto of(Set<Integer> numbers) {
        return new Lotto(numbers);
    }

    static Lotto of(List<Integer> numbers) {
        return Lotto.of(new HashSet<>(numbers));
    }

    static Lotto of(String number) {
        return Lotto.of(Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet()));
    }

    private static void validateSize(Set<Integer> numbers) {
        if (numbers.size() != LottoPolicy.LOTTO_SIZE)
            throw new LottoServiceException(LottoError.WRONG_LOTTO_NUMBER_SIZE);
    }

    private static void validateNumbers(Set<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= LottoPolicy.LOTTO_MINIMUM_NUMBER && number <= LottoPolicy.LOTTO_MAXIMUM_NUMBER))
            throw new LottoServiceException(LottoError.WRONG_LOTTO_RANGE);
    }
}
