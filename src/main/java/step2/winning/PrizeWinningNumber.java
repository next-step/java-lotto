package step2.winning;

import step2.lottery.AbstractLottery;
import step2.lottery.LotteryNumber;

import java.util.Set;

public class PrizeWinningNumber extends AbstractLottery {
    private final LotteryNumber bonusNumber;
    public PrizeWinningNumber(String input, int number) {
        super(input);
        bonusNumber = LotteryNumber.of(number);
        validateBonusNumber();
    }
    public boolean isMatchBounus(Set<LotteryNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    private void validateBonusNumber() {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}
