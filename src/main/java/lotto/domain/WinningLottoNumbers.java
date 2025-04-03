package lotto.domain;

import java.util.List;

/**
 * 당첨 번호, 보너스 번호를 저장
 */
public class WinningLottoNumbers {
    private final LottoTicket winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningLotto = new LottoTicket(winningNumbers);
        validateDuplication(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private static void validateDuplication(LottoTicket winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복일 수 없습니다.");
        }
    }

    public LottoTicket getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
