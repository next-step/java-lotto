package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.winningNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호 6개를 입력해주세요 :)");
        }
    }

    public List<Integer> toIntegerList() {
        return winningNumbers.stream()
                .map(n -> n.toInt())
                .collect(Collectors.toList());
    }
}
