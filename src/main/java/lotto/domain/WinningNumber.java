package lotto.domain;

import lotto.exception.LottoServiceException;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumber {

    private final Set<LottoNumber> numbers;
    private final LottoNumber bonusBall;

    private WinningNumber(Set<LottoNumber> numbers, LottoNumber bonusBall) {
        validateSize(numbers);
        this.numbers = numbers;
        this.bonusBall = bonusBall;
    }

    public static WinningNumber of(String number, int bonusBall) {
        return new WinningNumber(
                Collections.unmodifiableSet(Arrays.stream(number.split(LottoPolicy.LOTTO_SEPARATOR))
                        .map(Integer::parseInt)
                        .map(LottoNumber::of)
                        .collect(Collectors.toSet())), LottoNumber.of(bonusBall));
    }

    private static void validateSize(Set<LottoNumber> numbers) {
        if (numbers.size() != LottoPolicy.LOTTO_SIZE)
            throw new LottoServiceException(LottoError.WRONG_LOTTO_NUMBER_SIZE);
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
