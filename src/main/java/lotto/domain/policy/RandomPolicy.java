package lotto.domain.policy;

import java.util.Collections;
import java.util.List;

public class RandomPolicy implements DrawPolicy {

    @Override
    public void draw(List<Integer> candidates) {
        Collections.shuffle(candidates);
    }
}
