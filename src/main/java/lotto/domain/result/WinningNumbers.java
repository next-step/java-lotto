package lotto.domain.result;

import java.util.List;

public class WinningNumbers {
    public static final int COUNT_OF_WINNING_NUMBER = 6;

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validate(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_WINNING_NUMBER) {
            throw new IllegalArgumentException(String.format("당첨번호는 반드시 %d개여야 합니다", COUNT_OF_WINNING_NUMBER));
        }
    }

    public boolean contains(Integer lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }
}
