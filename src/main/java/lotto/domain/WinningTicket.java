package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningTicket {
    private final List<LottoNumber> winningLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningTicket(List<LottoNumber> winningLottoNumbers, LottoNumber bonusNumber) {
        validateBonusNumber(winningLottoNumbers, bonusNumber);
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningTicket of(List<Integer> winningNumbers, int bonusNumber) {
        List<LottoNumber> winningLottoNumbers = winningNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new WinningTicket(winningLottoNumbers, new LottoNumber(bonusNumber));
    }

    public int calculateMatchesCount(List<LottoNumber> lottoNumbers) {
        return (int) winningLottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.hasMatchesNumber(lottoNumbers))
                .count();
    }

    public boolean matchesBonus(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    private void validateBonusNumber(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼은 당첨번호와 중복될 수 없습니다.");
        }
    }
}
