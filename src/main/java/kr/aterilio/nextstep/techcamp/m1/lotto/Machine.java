package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Machine {

    public static final int IDX_START = 0;
    public static final int IDX_END_NOT_CLOSED = 6;

    private static final List<Integer> numberPool;
    public static final Integer[] EMPTY_INT_ARRAY = {0};

    static {
        numberPool = IntStream.rangeClosed(Lotto.LOTTO_BALL_MIN, Lotto.LOTTO_BALL_MAX)
                              .boxed()
                              .collect(Collectors.toList());
    }

    public static Integer[] draw() {
        Collections.shuffle(numberPool);
        return  numberPool.subList(IDX_START, IDX_END_NOT_CLOSED)
                          .toArray(EMPTY_INT_ARRAY);
    }
}
