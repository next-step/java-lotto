package step2.domain;

import java.util.Set;

class ManualSelection {
    private Set<LotteryNumber> lotteryNumbers;

    public ManualSelection(Set<LotteryNumber> lotteryNumbers) {

        this.lotteryNumbers = lotteryNumbers;
    }

    public Set<LotteryNumber> getLotteryNumbers() {
        return lotteryNumbers;
    }
}
