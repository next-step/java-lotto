package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 당첨 로또 클래스
 */
public class WinningNumber {
    private final LottoNumbers lottoNumbers;

    // String을 받아 우승 로또번호를 만든다.
    public WinningNumber(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        List<Integer> numberList = Arrays.stream(numbers)
            .map(String::trim)
            .mapToInt(
                v -> {
                    try {
                        return Integer.parseInt(v);
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("로또 번호는 숫자만 가능합니다.");
                    }
                }
            )
            .boxed()
            .collect(Collectors.toList());
        this.lottoNumbers = LottoNumbers.organized(numberList);
    }

    public WinningNumber(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers numbers() {
        return lottoNumbers;
    }
}
