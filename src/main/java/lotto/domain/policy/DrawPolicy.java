package lotto.domain.policy;

import java.util.List;

public interface DrawPolicy {
    void draw(List<Integer> candidates);

    default void apply(List<Integer> candidates) {
        draw(candidates);
    };
}
