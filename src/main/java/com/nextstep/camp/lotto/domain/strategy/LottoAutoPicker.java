package com.nextstep.camp.lotto.domain.strategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.nextstep.camp.lotto.domain.entity.LottoTicket;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;

public class LottoAutoPicker implements LottoPicker {

    private final LottoAmount amount;

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int PICK_COUNT = 6;
    private static final List<Integer> PICK_POOL = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX)
            .boxed()
            .collect(Collectors.toList());

    private LottoAutoPicker(LottoAmount amount) {
        this.amount = amount;
    }

    public static LottoAutoPicker of(LottoAmount amount) {
        return new LottoAutoPicker(amount);
    }

    @Override
    public List<LottoTicket> pick() {
        return IntStream.range(0, this.amount.lottoCount())
                .mapToObj(i -> LottoTicket.of(generateOne()))
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
