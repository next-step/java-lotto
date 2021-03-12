package lotto.domain;

import java.util.List;

public class WinningLotteryTicket {

    private final Lottery lottery;

    private final LotteryNumber bonusLotteryNumber;

    public WinningLotteryTicket(List<Integer> numberList, int bonusNumber) {
        validateBonusNumberIsDuplicateInLottery(numberList, bonusNumber);
        lottery = new Lottery(numberList);
        bonusLotteryNumber = new LotteryNumber(bonusNumber);
    }

    private void validateBonusNumberIsDuplicateInLottery(List<Integer> numberList, int bonusNumber) {
        if (numberList.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또번호로 채택퇸 번호는 보너스 번호로 사용할 수 없습니다.");
        }
    }

    public Lottery getLottery() {
        return lottery;
    }

    public LotteryNumber getBonusLotteryNumber() {
        return bonusLotteryNumber;
    }
}
