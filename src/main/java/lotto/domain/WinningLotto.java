package lotto.domain;

import lotto.tool.LottoMachine;

public class WinningLotto extends LottoTicket {

    private final LottoBall bonusBall;

    public WinningLotto(String[] winningNumbers, String bonusNumber) {
        super(LottoMachine.toLottoBalls(winningNumbers));
        this.bonusBall = new LottoBall(LottoMachine.toInt(bonusNumber));
        checkDuplication();
    }

    private void checkDuplication() {
        for (LottoBall lottoBall : this.lottoBalls) {
            super.isDuplicated(lottoBall, bonusBall);
        }
    }

    public boolean matchBonusNumber(LottoBall lottoBall) {
        return this.bonusBall.number == lottoBall.number;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
