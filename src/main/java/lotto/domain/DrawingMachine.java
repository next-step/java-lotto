package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DrawingMachine {
    private static final int WINNING_NUMBER_SIZE = 6;

    public final List<LottoNumber> winningNumbers;

    public DrawingMachine(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateDuplicateWinningNumbers(winningNumbers);
        this.winningNumbers = mapLottoNumbersByNumbers(winningNumbers);
    }

    private List<LottoNumber> mapLottoNumbersByNumbers(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .map(LottoNumberGenerator::findByNumber)
                .collect(Collectors.toList());
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호의 개수가 6이 아닙니다.");
        }
    }

    private void validateDuplicateWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(winningNumbers);

        if (nonDuplicateNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    public int drawLottoTicket(LottoTicket lottoTicket) {
        return (int) winningNumbers.stream()
                .filter(lottoTicket::isContainingLottoNumbers)
                .count();
    }
}
