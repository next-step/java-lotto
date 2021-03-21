package lotto.domain.policy;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestRandomPolicy implements DrawPolicy {

    @Override
    public void draw(List<Integer> candidates) {
        Collections.shuffle(candidates, new Random(10));
    }
}
