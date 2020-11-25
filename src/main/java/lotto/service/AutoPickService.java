package lotto.service;

import lotto.domain.LottoBalls;
import lotto.domain.LottoNumber;
import lotto.domain.Pick;
import lotto.domain.enums.PickType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutoPickService {

    private final List<Integer> balls;

    public AutoPickService() {
        balls = Stream.iterate(LottoNumber.LOTTO_NUMBER_RANGE_START, ballNumber -> ballNumber + 1)
                .limit(LottoNumber.LOTTO_NUMBER_RANGE_END)
                .collect(Collectors.toList());
    }

    public Pick pick() {
        Collections.shuffle(balls);
        return new Pick(PickType.AUTO, new LottoBalls(balls.subList(0, LottoBalls.LOTTO_BALL_VALID_COUNT)));
    }
}
