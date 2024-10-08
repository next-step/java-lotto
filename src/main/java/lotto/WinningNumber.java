package lotto;

import java.util.List;

public class WinningNumber {
    public static final int WINNING_NUMBERS_COUNT = 6;

    private final List<Integer> winningNumbers;

    private WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumber from(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 입니다.");
        }
        if (winningNumbers.stream().distinct().count() != WINNING_NUMBERS_COUNT) {
            throw new IllegalArgumentException("당첨 번호로 중복된 수를 사용할 수 없습니다.");
        }
        return new WinningNumber(winningNumbers);
    }

    public int matchLottoNumbers(LottoTicket lottoTicket) {
        return (int) winningNumbers.stream()
                .filter(lottoTicket::match)
                .count();
    }

}
