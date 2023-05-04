package step2;

import java.util.List;

public class LottoTicket {
    private final List<Integer> numbers;
    private int sameNumberCount;
    private int prizeResult;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
        this.sameNumberCount = 0;
        this.prizeResult = 0;
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


    public void checkWinningTicket(List<Integer> officialWinningNumbers) {
        sameNumberCount = getSameNumberCnt(officialWinningNumbers);
        prizeResult = LottoPrizeEnum.getPrizeBySameNumCnt(sameNumberCount);
        if (sameNumberCount < 3)
            sameNumberCount = 0;
    }

    private int getSameNumberCnt(List<Integer> officialWinningNumbers) {
        int sameNumberCount = 0;
        for (int winningNumber : officialWinningNumbers) {
            if (hasWinningNumber(winningNumber))
                sameNumberCount++;
        }
        return sameNumberCount;
    }

    private boolean hasWinningNumber(int winningNumber) {
        return numbers.contains(winningNumber);
    }

}
