package lotto.service;

import lotto.domain.LottoConstraint;
import lotto.domain.Pick;
import lotto.domain.enums.PickType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutoPickService {

    private final LottoService lottoService;

    private final List<Integer> balls;

    public AutoPickService(LottoService lottoService) {
        this.lottoService = lottoService;
        LottoConstraint constraint = lottoService.getConstraint();
        balls = Stream.iterate(1, ballNumber -> ballNumber + 1)
                .limit(constraint.getRange())
                .collect(Collectors.toList());
    }

    public Pick pick() {
        LottoConstraint constraint = lottoService.getConstraint();
        Collections.shuffle(balls);
        return new Pick(PickType.AUTO, balls.subList(0,constraint.getCountOfNumber()));
    }
}
