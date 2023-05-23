package step2.domain.Lotto;

import step2.domain.Constant;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBalls {
    public static final List<LottoNum> balls;

    static {
        balls = IntStream.rangeClosed(Constant.MIN_NUM, Constant.MAX_NUM)
                .mapToObj(LottoNum::new).collect(Collectors.toUnmodifiableList());
    }
}
