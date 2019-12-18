package lotto.domain;

import lotto.common.exception.WrongLottoNumberException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumber {

    private Set<Integer> numbers;

    private LottoNumber(Set<Integer> numbers) {
        validateNumbers(numbers);
        validateSize(numbers);
        this.numbers = numbers;
    }

    public static LottoNumber of(Set<Integer> numbers) {
        return new LottoNumber(numbers);
    }

    public static LottoNumber of(List<Integer> numbers) {
        return LottoNumber.of(new HashSet<>(numbers));
    }

    public static LottoNumber of(String number) {
        return LottoNumber.of(Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet()));
    }

    private static void validateSize(Set<Integer> numbers) {
        if (numbers.size() != 6)
            throw new WrongLottoNumberException("로또 넘버 사이즈는 6이어야 합니다.");
    }

    private static void validateNumbers(Set<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number == 0 || number > 45))
            throw new WrongLottoNumberException("로또 넘버는 1-45 사이를 입력해주십시오.");
    }
}
