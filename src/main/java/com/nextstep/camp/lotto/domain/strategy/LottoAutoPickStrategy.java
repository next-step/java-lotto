package com.nextstep.camp.lotto.domain.strategy;

import com.nextstep.camp.lotto.domain.entity.LottoTicket;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoPickStrategy implements LottoPickStrategy {

    private final LottoAmount amount;

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int PICK_COUNT = 6;

    private LottoAutoPickStrategy(LottoAmount amount) {
        this.amount = amount;
    }

    public static LottoAutoPickStrategy of(LottoAmount amount) {
        return new LottoAutoPickStrategy(amount);
    }

    @Override
    public List<LottoTicket> generate() {
        return IntStream.range(0, this.amount.lottoCount())
                .mapToObj(i -> LottoTicket.of(generateOne()))
                .collect(Collectors.toList());
    }

    private List<Integer> generateOne() {
        List<Integer> pool = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(pool);
        return pool.stream()
                .limit(PICK_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }
}
