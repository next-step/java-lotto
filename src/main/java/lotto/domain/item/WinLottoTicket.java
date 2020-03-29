package lotto.domain.item;

import java.util.List;
import java.util.Objects;

public class WinLottoTicket extends Lotto {

    private final int second;

    public WinLottoTicket(List<Integer> numbers, int second) {
        super(numbers);
        this.second = second;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WinLottoTicket that = (WinLottoTicket) o;
        return second == that.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), second);
    }
}
