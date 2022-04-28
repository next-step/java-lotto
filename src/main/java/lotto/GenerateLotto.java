package lotto;

import java.util.ArrayList;
import java.util.List;

public class GenerateLotto {

    private GenerateLotto() {
        throw new AssertionError();
    }

    public static Lottos get() {
        List<Integer> lottos = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottos.add(i);
        }
        return new Lottos(lottos);
    }
}
