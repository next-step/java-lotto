package step2.domain;

import java.util.Objects;
import java.util.Set;

public class LotteryTickets {
    private final Set<LotteryNumber> numbers;
    private final int manualSelectionCount;
    private final int naturalSelectionCount;

    public LotteryTickets(Set<LotteryNumber> numbers) {
        this(0, 0, numbers);
    }

    public LotteryTickets(int manualSelectionCount, int naturalSelectionCount, Set<LotteryNumber> selectNumbers) {
        this.manualSelectionCount = manualSelectionCount;
        this.naturalSelectionCount = naturalSelectionCount;
        numbers = selectNumbers;
    }

    public static LotteryTickets of(Playslip playslip) {
        return new LotteryTickets(playslip.getManualSelectionCount(), playslip.getNaturalSelectionCount(), playslip.selectNumbers(0));
    }

    public int size() {
        return numbers.size();
    }

    public Set<LotteryNumber> getTicketNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LotteryTickets that = (LotteryTickets) o;
        return manualSelectionCount == that.manualSelectionCount && naturalSelectionCount == that.naturalSelectionCount && numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, manualSelectionCount, naturalSelectionCount);
    }

    @Override
    public String toString() {
        return "LotteryTickets{" + "numbers=" + numbers + ", manualSelectionCount=" + manualSelectionCount + ", naturalSelectionCount=" + naturalSelectionCount + '}';
    }
}
