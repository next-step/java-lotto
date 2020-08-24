package lotto.domain;

import java.util.Set;

public class WinningLotto {

    private LottoTicket winningLottoTicket;
    private LottoNumber bonusBall;

    private WinningLotto(Set<LottoNumber> lottoNumbers, int bonusBall) {
        this.winningLottoTicket = LottoTicket.valueOf(lottoNumbers);
        validateBonusBallDuplication(bonusBall);
        this.bonusBall = LottoNumber.valueOf(bonusBall);
    }

    public static WinningLotto valueOf(Set<LottoNumber> lottoNumbers, int bonusBall) {
        return new WinningLotto(lottoNumbers, bonusBall);
    }

    private void validateBonusBallDuplication(int bonusBall) {
        if (winningLottoTicket.matchLottoNumber(LottoNumber.valueOf(bonusBall))) {
            throw new IllegalArgumentException("보너스 볼이 당첨 번호에 포함되어 있습니다. 다른 값을 입력하세요.");
        }
    }

    public LottoTicket getWinningLottoTicket() {
        return winningLottoTicket;
    }

    public boolean isBonusBall(LottoTicket lottoTicket) {
        return lottoTicket.matchLottoNumber(this.bonusBall);
    }
}
