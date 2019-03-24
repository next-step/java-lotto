package lotto.domain;

import lotto.tool.LottoAutoGenerator;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends LottoTicket {

    private final LottoBall bonusBall;

    public WinningLotto(String[] winningNumbers, String bonusNumber) {
        super(toLottoBalls(winningNumbers));
        this.bonusBall = new LottoBall(toInt(bonusNumber));
        checkDuplication();
    }

    private void checkDuplication() {
        for (LottoBall lottoBall : this.lottoBalls) {
            super.isDuplicated(lottoBall, bonusBall);
        }
    }

    private static List<LottoBall> toLottoBalls(String[] winningNumbers) {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (String winningNumber : winningNumbers) {
            lottoBalls.add(new LottoBall(toInt(winningNumber)));
        }
        return LottoAutoGenerator.sort(lottoBalls);
    }

    public boolean matchBonusNumber(LottoBall lottoBall) {
        return this.bonusBall.number == lottoBall.number;
    }

    private static Integer toInt(String number) {
        return Integer.parseInt(number);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
