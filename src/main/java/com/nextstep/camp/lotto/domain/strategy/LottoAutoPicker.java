package com.nextstep.camp.lotto.domain.strategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.nextstep.camp.lotto.domain.entity.LottoTicket;
import com.nextstep.camp.lotto.domain.vo.LottoCount;

public class LottoAutoPicker implements LottoPicker {

    private final LottoCount count;

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int PICK_COUNT = 6;
    private static final List<Integer> PICK_POOL = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX)
            .boxed()
            .collect(Collectors.toList());

    private LottoAutoPicker(LottoCount count) {
        this.count = count;
    }

    public static LottoAutoPicker of(LottoCount amount) {
        return new LottoAutoPicker(amount);
    }

    @Override
    public List<LottoTicket> pick() {
        return this.count.intStream()
            .mapToObj(count -> LottoTicket.of(generateOne()))
            .collect(Collectors.toList());
    }

    private List<Integer> generateOne() {
        Collections.shuffle(PICK_POOL);
        return PICK_POOL.stream()
                .limit(PICK_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }
}
