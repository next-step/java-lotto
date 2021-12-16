package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

import java.util.List;
import java.util.Objects;

public class ManualLottoRequest {
    private static final int NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    private ManualLottoRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static ManualLottoRequest from(List<Integer> numbers) {
        validate(numbers);
        return new ManualLottoRequest(numbers);
    }

    public Lotto toLotto() {
        return new Lotto(new LottoNumbers(numbers));
    }

    private static void validate(List<Integer> numbers) {
        if (Objects.isNull(numbers)) {
            throw new IllegalArgumentException("numbers가 null이 전달되었습니다.");
        }
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(String.format("전달된 숫자의 사이즈(%d)는 %d개이어야합니다.", numbers.size(), NUMBER_SIZE));
        }
    }

    private static boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != NUMBER_SIZE;
    }
}
