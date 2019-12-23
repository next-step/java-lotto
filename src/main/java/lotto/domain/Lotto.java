package lotto.domain;

import lotto.exception.LottoServiceException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Lotto {

    private Set<LottoNumber> numbers;

    private Lotto(Set<LottoNumber> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    static Lotto of(Set<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    static Lotto of(List<LottoNumber> numbers) {
        return Lotto.of(new HashSet<>(numbers));
    }

    static Lotto of(String number) {
        return Lotto.of(Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    private static void validateSize(Set<LottoNumber> numbers) {
        if (numbers.size() != LottoPolicy.LOTTO_SIZE)
            throw new LottoServiceException(LottoError.WRONG_LOTTO_NUMBER_SIZE);
    }

    public String getNumbersAsString() {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

}
