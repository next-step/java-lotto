package lotto.domain;

import java.util.Objects;

public class WinningLotto {

    public static final String INCLUDE_BONUS_BALL_ERROR = "보너스 볼이 당첨 번호에 포함되어 있습니다. 다른 값을 입력하세요.";
    private final LottoTicket winningLottoTicket;
    private LottoNumber bonusBall;

    private WinningLotto(LottoTicket winningLottoTicket, int bonusBall) {
        this.winningLottoTicket = winningLottoTicket;
        validateBonusBallDuplication(bonusBall);
        this.bonusBall = LottoNumber.ofNumber(bonusBall);
    }

    private void validateBonusBallDuplication(int bonusBall) {
        if (winningLottoTicket.matchLottoNumber(LottoNumber.ofNumber(bonusBall))) {
            throw new IllegalArgumentException(INCLUDE_BONUS_BALL_ERROR);
        }
    }

    public boolean isBonusBall(LottoTicket lottoTicket) {
        return lottoTicket.matchLottoNumber(this.bonusBall);
    }

    public LottoTicket getWinningLottoTicket() {
        return winningLottoTicket;
    }

    public static class Builder {
        private LottoTicket lottoTicket;
        private int bonusBall;

        public Builder winningLottoTicket(LottoTicket lottoTicket) {
            this.lottoTicket = lottoTicket;
            return this;
        }

        public Builder bonusBall(int bonusBall) {
            this.bonusBall = bonusBall;
            return this;
        }

        public WinningLotto build() {
            return new WinningLotto(lottoTicket, bonusBall);
        }
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

}
