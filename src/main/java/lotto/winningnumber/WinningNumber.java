package lotto.winningnumber;

import lotto.ticket.LottoTicket;

import java.util.List;

import static lotto.ticket.LottoTicket.*;

public class WinningNumber {
    private final List<Integer> winningNumbers;

    private WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumber from(List<Integer> winningNumbers) {
        validateNumberOfWinningNumbers(winningNumbers);
        validateNoDuplicateNumbers(winningNumbers);
        validateNumberRange(winningNumbers);

        return new WinningNumber(winningNumbers);
    }

    private static void validateNumberOfWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() == NUMBER_OF_LOTTO_NUMBERS) {
            return;
        }
        throw new IllegalArgumentException("당첨 번호는 6개 입니다.");
    }

    private static void validateNoDuplicateNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() == winningNumbers.size()) {
            return;
        }
        throw new IllegalArgumentException("당첨 번호로 중복된 수를 사용할 수 없습니다.");
    }

    private static void validateNumberRange(List<Integer> winningNumbers) {
        boolean isValidNumbers = winningNumbers.stream()
                .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);

        if (isValidNumbers) {
            return;
        }
        throw new IllegalArgumentException("당첨 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + "까지 입니다.");
    }

    public int matchLottoNumbers(LottoTicket lottoTicket) {
        return (int) winningNumbers.stream()
                .filter(lottoTicket::match)
                .count();
    }
}
