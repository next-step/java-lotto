package step4.domain;

import step4.domain.LottoFactory.LottoNo;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private final LottoNo bonusBall;

    public WinningNumbers(int[] lottoNos, int bonusBall) {
        this.winningNumbers = LottoFactory.createByLottoNos(lottoNos);
        this.bonusBall = LottoFactory.pickLottoBall(bonusBall);
    }

    public Rank getRank(Lotto lotto) {
        int winningNumbersCount = lotto.findWinningNumbersCount(winningNumbers);
        boolean matchBonus = lotto.containsLottoNo(bonusBall);
        return Rank.valueOf(winningNumbersCount, matchBonus);
    }

}
