package lotto.domain;

import lotto.domain.enums.PickType;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class Pick {
    private final Set<Integer> balls = new TreeSet<>();
    private PickType type;

    public void setBalls(Collection<Integer> balls) {
        this.balls.addAll(balls);
    }

    public Set<Integer> getBalls() {
        return balls;
    }

    public void setType(PickType type) {
        this.type = type;
    }

    public PickType getType() {
        return type;
    }
}
