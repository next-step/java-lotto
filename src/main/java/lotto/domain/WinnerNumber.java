package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerNumber {

    private List<LottoNumber> winnerNumbers;
    private static final int NUMBER_SIZE = 6;

    public WinnerNumber(List<Integer> numbers) {
        validate(numbers.size());
        this.winnerNumbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    private void validate(int size) {
        if (size != NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format("당첨 번호는 %s개 입니다.", NUMBER_SIZE));
        }
    }

    public int matchCount(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
            .filter(lottoNumber -> winnerNumbers.contains(lottoNumber))
            .mapToInt(value -> 1)
            .sum();
    }
}
