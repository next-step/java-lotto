package step2;

import java.util.List;

public class LottoTicket {
    private final List<Integer> numbers;
    private int sameNumberCount;
    private int prizeResult;
    private boolean hasBonusNum;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
        this.sameNumberCount = 0;
        this.prizeResult = 0;
        this.hasBonusNum = false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getSameNumberCount() {
        return sameNumberCount;
    }

    public int getPrizeResult() {
        return prizeResult;
    }


    public void checkWinningTicket(List<Integer> officialWinningNumbers, int bonusNumber) {
        sameNumberCount = getSameNumberCnt(officialWinningNumbers);

        if (checkBonusNumber(bonusNumber)) sameNumberCount++;
        prizeResult = LottoPrizeEnum.getPrizeBySameNumCnt(sameNumberCount, hasBonusNum);

        if (sameNumberCount < 3) sameNumberCount = 0;
    }

    private int getSameNumberCnt(List<Integer> officialWinningNumbers) {
        return (int) officialWinningNumbers.stream().filter(this::hasWinningNumber).count();
    }

    private boolean hasWinningNumber(int winningNumber) {
        return numbers.contains(winningNumber);
    }

    private boolean checkBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) hasBonusNum = true;
        return hasBonusNum;
    }
}
