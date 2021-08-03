package lotto.domain;

import java.util.*;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;

    private static final List<Ball> ballList = initList();

    private static List<Ball> initList() {
        List<Ball> ballList = new ArrayList<>(Ball.MAX_NUMBER);
        for (int i = Ball.MIN_NUMBER; i <= Ball.MAX_NUMBER; i++) {
            ballList.add(new Ball(i));
        }
        return ballList;
    }

    public static List<Lotto> buyRandomLotto(int totalMoney) {
        int count = totalMoney / LOTTO_PRICE;
        List<Lotto> lottoList = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(get6RandomBall()));
        }
        return lottoList;
    }

    private static Set<Ball> get6RandomBall() {
        Set<Ball> ballSet = new HashSet<>();

        while (ballSet.size() != Lotto.NUMBER_SIZE) {
            Collections.shuffle(ballList);
            ballSet.add(ballList.get(0));
        }
        return ballSet;
    }
}
