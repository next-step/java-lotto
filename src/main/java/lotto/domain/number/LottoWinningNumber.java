package lotto.domain.number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoWinningNumber {
    private static final int WINNING_NUMBER_SIZE = 6;
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);

        this.winningNumbers = convertLottoNumbers(winningNumbers);
        this.bonusNumber = LottoNumber.valueOf(bonusNumber);
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    private List<LottoNumber> convertLottoNumbers(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private void validateDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복 될 수 없습니다. - " + bonusNumber);
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumberSize(winningNumbers);
        validateDuplicateWinningNumbers(winningNumbers);
    }

    private void validateWinningNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호의 갯수가 6이 아닙니다. - " + winningNumbers);
        }
    }

    private void validateDuplicateWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> nonDupulicateNumbers = new HashSet<>(winningNumbers);

        if (nonDupulicateNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복되는 당첨 번호가 존재합니다. - " + winningNumbers);
        }
    }
}
