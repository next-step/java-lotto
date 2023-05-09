package lottery;

import java.util.Set;

public class Lottery {
    private final LotteryRow row;

    public Lottery(LotteryRow row) {
        this.row = row;
    }

    public Set<Integer> getNumbers() {
        return row.getNumbers();
    }
}
