package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;
    private static final List<Ball> BALLS_POOL = IntStream.rangeClosed(Ball.MIN_NUMBER, Ball.MAX_NUMBER)
            .mapToObj(Ball::from)
            .collect(Collectors.toList());

    public static List<Lotto> buyRandomLotto(int totalMoney) {
        int count = totalMoney / LOTTO_PRICE;
        List<Lotto> lottoList = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            lottoList.add(Lotto.from(get6RandomBall()));
        }
        return lottoList;
    }

    private static Set<Ball> get6RandomBall() {
        Collections.shuffle(BALLS_POOL);
        return new HashSet<>(BALLS_POOL.subList(0, 6));
    }
}
