package step2.domain;

import java.util.Collections;
import java.util.Set;

class ManualSelection {
    private final Set<LotteryNumber> lotteryNumbers;

    public ManualSelection(Set<LotteryNumber> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public ManualSelection() {
        this(Collections.emptySet());
    }

    public Set<LotteryNumber> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public int size() {
        return lotteryNumbers.size();
    }
}
