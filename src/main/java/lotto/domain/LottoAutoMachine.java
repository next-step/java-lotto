package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoMachine {

    private static final int LOTTO_START_INDEX = 0;
    private static final int LOTTO_END_INDEX = 6;
    public static final int PRICE = 1000;

    private static final List<Integer> numberPool = IntStream.range(LottoNumber.MIN_NUM, LottoNumber.MAX_NUM+1).boxed().collect(Collectors.toList());

    private LottoAutoMachine() {
    }

    private static Lotto makeLotto() {
        Collections.shuffle(numberPool);
        List<Integer> integers = numberPool.subList(LOTTO_START_INDEX, LOTTO_END_INDEX);
        return new Lotto(integers);
    }

    public static Lottos makeLottos(int paying) {
        int count = paying / PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(makeLotto());
        }
        return new Lottos(lottos);
    }
}

