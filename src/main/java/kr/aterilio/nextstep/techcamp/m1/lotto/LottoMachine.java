package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.*;

public class LottoMachine {

    private static final int IDX_START = 0;
    private static final int IDX_END_NOT_CLOSED = 6;

    private static final Map<Integer, LottoBall> numberPool;

    static {
        numberPool = new HashMap<>();
        for (int i = LottoBall.MIN; i <= LottoBall.MAX; i++) {
            numberPool.put(i, new LottoBall(i));
        }
    }

    public static Optional<LottoBall> of(int ball) {
        return Optional.ofNullable(numberPool.get(ball));
    }

    public static Lotto draw() {
        List<LottoBall> collections = new ArrayList<>(numberPool.values());
        Collections.shuffle(collections);
        return new Lotto(collections.subList(IDX_START, IDX_END_NOT_CLOSED));
    }
}
