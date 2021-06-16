package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int IDX_START = 0;
    private static final int IDX_END_NOT_CLOSED = 6;

    private static final List<LottoBall> numberPool;

    static {
        numberPool = new ArrayList<>();
        for (int i = LottoBall.MIN; i < LottoBall.MAX; i++) {
            numberPool.add(LottoBall.of(i));
        }
    }

    public static Lotto draw() {
        Collections.shuffle(numberPool);
        return new Lotto(numberPool.subList(IDX_START, IDX_END_NOT_CLOSED));
    }
}
