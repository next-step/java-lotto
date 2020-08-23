package lotto.domain;

import java.util.Set;

public class WinningLotto {

    private LottoTicket winningLottoTicket;
    private LottoNumber bonusBall;

    public WinningLotto(Set<LottoNumber> lottoNumbers, int bonusBall) {
        this.winningLottoTicket = new LottoTicket(lottoNumbers);
        validateBonusBallDuplication(bonusBall);
        this.bonusBall = new LottoNumber(bonusBall);
    }

    public void validateBonusBallDuplication(int bonusBall) {
        if (winningLottoTicket.matchLottoNumber(new LottoNumber(bonusBall))) {
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
