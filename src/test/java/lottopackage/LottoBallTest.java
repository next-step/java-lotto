package lottopackage;

import lottopackage.vo.Lotto;
import lottopackage.vo.LottoBall;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBallTest {
    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 45;

    private final static Set<Integer> lotteryBalls = new HashSet<>(
            Arrays.stream(IntStream.rangeClosed(MIN_VALUE, MAX_VALUE).toArray())
                    .boxed()
                    .collect(Collectors.toSet()));


    @Test
    @DisplayName("LottoBall 기본 생성 시 1~45 안에 들어가는지?")
    public void lottoBallDefaultConstructor() {
        LottoBall lottoBall = new LottoBall();
        Assertions.assertThat(lotteryBalls.contains(lottoBall.getLottoBall())).isEqualTo(true);
    }

    @Test
    @DisplayName("LottoBall 수동 생성 시 1~45 안에 들어가지 않으면 Exception이 나는지?")
    public void lottoBallConstructor() {
        Assertions.assertThatThrownBy(() -> {
            new LottoBall(0);
        }).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> {
            new LottoBall(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
