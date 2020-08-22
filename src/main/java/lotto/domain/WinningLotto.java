package lotto.domain;

import java.util.Set;

public class WinningLotto {

    private LottoTicket winningLottoNumber;
    private LottoNumber bonusBall;

    public WinningLotto(Set<LottoNumber> lottoNumbers, int bonusBall) {
        this.winningLottoNumber = new LottoTicket(lottoNumbers);
        validateBonusBallDuplication(bonusBall);
        this.bonusBall = new LottoNumber(bonusBall);
    }

    public void validateBonusBallDuplication(int bonusBall) {
        if (winningLottoNumber.getLottoTicketNumbers().contains(new LottoNumber(bonusBall))) {
            throw new IllegalArgumentException("보너스 볼이 당첨 번호에 포함되어 있습니다. 다른 값을 입력하세요.");
        }
    }

    public LottoTicket getWinningLottoNumber() {
        return winningLottoNumber;
    }

    public boolean isBonusBall(LottoTicket lottoTicket) {
        return lottoTicket.getLottoTicketNumbers()
                .contains(this.bonusBall);
    }
}
