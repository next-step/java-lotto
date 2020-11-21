package step2.domain;

import java.util.List;
import java.util.Objects;

public class LotteryTickets {
    public static LotteryTickets of(List<LotteryNumber> selectNumbers, int manualSelectionCount) {
        int naturalSelectionCount = selectNumbers.size() - manualSelectionCount;
        return new LotteryTickets(manualSelectionCount, naturalSelectionCount, selectNumbers);
    }

    private final List<LotteryNumber> selectNumbers;
    private final int manualSelectionCount;
    private final int naturalSelectionCount;

    public LotteryTickets(List<LotteryNumber> selectNumbers) {
        this(0, selectNumbers.size(), selectNumbers);
    }

    public LotteryTickets(int manualSelectionCount, int naturalSelectionCount, List<LotteryNumber> selectNumbers) {
        this.manualSelectionCount = manualSelectionCount;
        this.naturalSelectionCount = naturalSelectionCount;
        this.selectNumbers = selectNumbers;
    }

    public int getNaturalSelectionCount() {
        return naturalSelectionCount;
    }

    public int getManualSelectionCount() {
        return manualSelectionCount;
    }

    public List<LotteryNumber> getTicketNumbers() {
        return selectNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LotteryTickets that = (LotteryTickets) o;
        return manualSelectionCount == that.manualSelectionCount //
                && naturalSelectionCount == that.naturalSelectionCount //
                && selectNumbers.equals(that.selectNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectNumbers, manualSelectionCount, naturalSelectionCount);
    }

    @Override
    public String toString() {
        return "LotteryTickets{numbers=" + selectNumbers //
                + ", manualSelectionCount=" + manualSelectionCount //
                + ", naturalSelectionCount=" + naturalSelectionCount + '}';
    }
}
