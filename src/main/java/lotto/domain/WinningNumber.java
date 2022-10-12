package lotto.domain;

import java.util.List;

public class WinningNumber {


    private List<Integer> lottoNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> lottoNumbers, int bonusNumber) {
        validateWinningNumber(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호에 포함되어 있습니다.");
        }
    }

    public MatchingResult results(List<Integer> lottoNumbers) {
        int matchingCount = (int) this.lottoNumbers.stream()
                .filter(winningNumber -> lottoNumbers.contains(winningNumber))
                .count();

        boolean containBonusNumber = lottoNumbers.contains(this.bonusNumber);

        return new MatchingResult(matchingCount, containBonusNumber);
    }
}
