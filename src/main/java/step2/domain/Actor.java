package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Actor {

    public List<Integer> choose() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            result.add(ThreadLocalRandom.current().nextInt(0, 45));
        }

        return result;
    }
}
