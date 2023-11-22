package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lottery {

    public static final int WINNING_STREAK = 6;

    private List<Integer> win;
    private final Balls balls;

    public Lottery(Balls balls) {
        this.balls = balls;
    }

    public static Lottery of(Set<Integer> numbers) {
        return new Lottery(Balls.of(new ArrayList<>(numbers)));
    }

    public List<Integer> getBalls() {
        return balls.getBalls();
    }

    public void setWin(List<Integer> win) {
        this.win = win;
    }

    public int getWinCount() {
        int winCount = 0;
        for (int number : getBalls()) {
            if (win.contains(number)) {
                winCount++;
            }
        }

        return winCount;
    }
}
