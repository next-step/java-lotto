package lotto.domain;

import java.util.Objects;
import java.util.Set;

public class WinningLotto {

    public static final String INCLUDE_BONUS_BALL_ERROR = "보너스 볼이 당첨 번호에 포함되어 있습니다. 다른 값을 입력하세요.";
    private final LottoTicket winningLottoTicket;
    private LottoNumber bonusBall;

    private WinningLotto(LottoTicket winningLottoTicket, int bonusBall) {
        this.winningLottoTicket = winningLottoTicket;
        validateBonusBallDuplication(bonusBall);
        this.bonusBall = LottoNumber.ofNumber(bonusBall);
    }

    public static WinningLotto ofLottoNumbers(LottoTicket lottoTicket, int bonusBall) {
        return new WinningLotto(lottoTicket, bonusBall);
    }

    private void validateBonusBallDuplication(int bonusBall) {
        if (winningLottoTicket.matchLottoNumber(LottoNumber.ofNumber(bonusBall))) {
            throw new IllegalArgumentException(INCLUDE_BONUS_BALL_ERROR);
        }
    }

    public LottoTicket getWinningLottoTicket() {
        return winningLottoTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLottoTicket, that.winningLottoTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLottoTicket);
    }

    public boolean isBonusBall(LottoTicket lottoTicket) {
        return lottoTicket.matchLottoNumber(this.bonusBall);
    }
}
