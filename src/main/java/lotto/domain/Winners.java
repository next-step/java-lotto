package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<Winner> winners;

    public Winners(List<Winner> winners) {
        this.winners = winners;
    }

    public List<Winner> getWinners() {
        return Collections.unmodifiableList(winners);
    }

    public int getTotalAmount() {
        return winners.stream()
                .mapToInt(winner -> winner.getAmount() * winner.getCount().intValue())
                .sum();
    }
}
