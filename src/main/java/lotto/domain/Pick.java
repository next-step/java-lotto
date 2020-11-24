package lotto.domain;

import lotto.domain.enums.PickType;
import lotto.domain.enums.Rank;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Pick {
    private PickType type;
    private final Set<Integer> balls = new TreeSet<>();
    private Rank rank;

    public Pick() {
    }

    public Pick(PickType pickType, Collection<Integer> balls) {
        this.type = pickType;
        this.balls.addAll(balls);
    }

    public Set<Integer> getBalls() {
        return balls;
    }

    public PickType getType() {
        return type;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Rank getRank() {
        return this.rank;
    }

    public int checkWinningBallCount(Collection<Integer> winningBalls) {
        return (int) balls.stream().filter(winningBalls::contains).count();
    }

    public String getBallsString() {
        return balls.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
