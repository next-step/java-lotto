package lotto.domain;

import java.util.*;

public class LottoMachine {

    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    public static final int LOTTO_PRICE = 1000;

    private static List<Ball> ballList = initList();

    private static List<Ball> initList() {
        List<Ball> ballList = new ArrayList<>(MAX_NUMBER);
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
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

        while (ballSet.size() != LOTTO_NUMBER_SIZE) {
            Collections.shuffle(ballList);
            ballSet.add(ballList.get(0));
        }
        return ballSet;
    }
}
