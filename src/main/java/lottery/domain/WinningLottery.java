package lottery.domain;

public class WinningLottery {

    private final LotteryNumbers winningNumbers;
    private final LotteryNumber bonusNumber;

    public WinningLottery(LotteryNumbers winningNumbers, LotteryNumber bonusNumber) {
        validateDuplicates(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Prize getPrize(LotteryNumbers lotteryNumbers) {
        long matchedNumbers = winningNumbers.countMatchedNumbers(lotteryNumbers);
        boolean bonusNumberMatched = lotteryNumbers.contain(bonusNumber);

        return Prize.getPrize(matchedNumbers, bonusNumberMatched);
    }

    private void validateDuplicates(LotteryNumbers lotteryNumbers, LotteryNumber bonusNumber) {
        if (lotteryNumbers.contain(bonusNumber)) {
            throw new DuplicatedBonusNumberException();
        }
    }

}
