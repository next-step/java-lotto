package lotto.model.domain;

public class CountInfo {

    private static final int MIN_COUNT = 0;
    private final int manualCount;
    private final int autoCount;

    public CountInfo(int manualCount, int lotteryCount) {
        checkValidation(manualCount, lotteryCount);
        this.manualCount = manualCount;
        this.autoCount = lotteryCount - manualCount;
    }

    public int getManualCount() {
        return this.manualCount;
    }

    public int getAutoCount() {
        return this.autoCount;
    }

    public boolean haveManualLottery() {
        return manualCount > MIN_COUNT;
    }

    private void checkValidation(int manualCount, int lotteryCount) {
        if(manualCount < MIN_COUNT) {
            throw new IllegalArgumentException("0보다 큰 숫자를 입력하셔야 합니다.");
        }
        if(lotteryCount < manualCount) {
            throw new IllegalArgumentException("수동으로 구매할 수 있는 로또 수를 넘었습니다.");
        }
    }
}
