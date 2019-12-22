package lotto.domain;

import lotto.common.exception.WrongLottoNumberException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private Set<Integer> numbers;

    private Lotto(Set<Integer> numbers) {
        validateNumbers(numbers);
        validateSize(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(Set<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto of(List<Integer> numbers) {
        return Lotto.of(new HashSet<>(numbers));
    }

    public static Lotto of(String number) {
        return Lotto.of(Arrays.stream(number.split(","))
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
