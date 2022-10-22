package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winnings {
    private final List<Winning> winnings;
    
    public Winnings() {
        this(new ArrayList<>());
    }
    
    public Winnings(final Winning... winnings) {
        this(Arrays.stream(winnings).collect(Collectors.toList()));
    }
    
    public Winnings(final List<Winning> winnings) {
        this.winnings = winnings;
    }

    public void add(Winning winning) {
        winnings.add(winning);
    }

    public List<Winning> getWinnings() {
        List<Winning> winnings = new ArrayList<>();
        for (Winning winning : this.winnings) {
            if (winning.hasPrize()) {
                winnings.add(winning);
            }
        }
        return winnings;
    }

    public Money income() {
        Money income = Money.ZERO;
        for (Winning winning : winnings) {
            income = income.plus(winning.prizeMoney());
        }
        return income;
    }
}
