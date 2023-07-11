package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private final List<Ball> balls;

    public LottoGenerator() {
        balls = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            balls.add(new Ball(String.valueOf(i)));
        }
    }

    public List<Lotto> generate(final Money money) {
        int count = money.getValue() / 1000;
        List<Lotto> boughtLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(balls);
            boughtLottos.add(new Lotto(balls.subList(0, 6)));
        }
        return boughtLottos;
    }
}
