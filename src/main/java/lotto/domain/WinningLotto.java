package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class WinningLotto extends LottoTicket{

    private final LottoBall bonusBall;

    public WinningLotto(String[] winningNumbers, String bonusNumber) {
        super(toLottoBalls(winningNumbers));
        this.bonusBall = new LottoBall(toInt(bonusNumber));
    }

    private static List<LottoBall> toLottoBalls(String[] winningNumbers) {
        List<LottoBall> lottoBalls = new ArrayList<>();
        for (String winningNumber : winningNumbers) {
            lottoBalls.add(new LottoBall(toInt(winningNumber)));
        }
        return lottoBalls;
    }

    public boolean matchBonusNumber(LottoBall lottoBall) {
        return this.bonusBall.number == lottoBall.number;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
