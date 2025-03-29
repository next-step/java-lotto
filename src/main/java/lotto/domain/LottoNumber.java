package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int LOTTO_NUM_MIN = 1;
    public static final int LOTTO_NUM_MAX = 45;

    private static final LottoNumber INSTANCE = new LottoNumber();
    private final List<Integer> numberPool;

    private LottoNumber() {
        this.numberPool = IntStream.rangeClosed(LOTTO_NUM_MIN, LOTTO_NUM_MAX)
                .boxed()
                .collect(Collectors.toList());
    }

    public static LottoNumber getInstance() {
        return INSTANCE;
    }

    public List<Integer> getShuffledNumbers() {
        List<Integer> copy = new ArrayList<>(numberPool); // 방어적 복사
        Collections.shuffle(copy);
        return copy;
    }
}
