package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private final List<Ball> balls;

    public LottoGenerator() {
        balls = new ArrayList<>();
        for (int i = Ball.MIN_NUMBER; i <= Ball.MAX_NUMBER; i++) {
            balls.add(new Ball(i));
        }
    }

    public List<Lotto> generate(final Money money) {
        final int count = money.getValue() / Lotto.PRICE;
        final List<Lotto> boughtLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(balls);
            boughtLottos.add(new Lotto(balls.subList(0, Lotto.SIZE)));
        }
        return boughtLottos;
    }
}
