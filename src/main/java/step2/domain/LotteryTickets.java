package step2.domain;

import java.util.Objects;
import java.util.Set;

public class LotteryTickets {
    private final Set<LotteryNumber> selectNumbers;
    private final int manualSelectionCount;
    private final int naturalSelectionCount;

    public LotteryTickets(Set<LotteryNumber> selectNumbers) {
        this(0, selectNumbers.size(), selectNumbers);
    }

    public LotteryTickets(int manualSelectionCount, int naturalSelectionCount, Set<LotteryNumber> selectNumbers) {
        this.manualSelectionCount = manualSelectionCount;
        this.naturalSelectionCount = naturalSelectionCount;
        this.selectNumbers = selectNumbers;
    }

    public static LotteryTickets of(Set<LotteryNumber> selectNumbers, int manualSelectionCount) {
        int naturalSelectionCount = selectNumbers.size() - manualSelectionCount;
        return new LotteryTickets(manualSelectionCount, naturalSelectionCount, selectNumbers);
    }

    public int size() {
        return selectNumbers.size();
    }

    public Set<LotteryNumber> getTicketNumbers() {
        return selectNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LotteryTickets that = (LotteryTickets) o;
        return manualSelectionCount == that.manualSelectionCount && naturalSelectionCount == that.naturalSelectionCount && selectNumbers.equals(that.selectNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectNumbers, manualSelectionCount, naturalSelectionCount);
    }

    @Override
    public String toString() {
        return "LotteryTickets{" + "numbers=" + selectNumbers + ", manualSelectionCount=" + manualSelectionCount + ", naturalSelectionCount=" + naturalSelectionCount + '}';
    }
}
