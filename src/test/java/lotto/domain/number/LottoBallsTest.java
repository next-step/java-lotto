package lotto.domain.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.exception.InvalidLottoBallsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

class LottoBallsTest {

    @Test
    @DisplayName("로또볼 리스트는 오름차순으로 정렬되어 반환된다.")
    void get_sorted_lotto_balls() {
        LottoBall lottoBall1 = new LottoBall(1);
        LottoBall lottoBall2 = new LottoBall(2);
        LottoBall lottoBall3 = new LottoBall(3);
        LottoBall lottoBall4 = new LottoBall(4);
        LottoBall lottoBall5 = new LottoBall(5);
        LottoBall lottoBall6 = new LottoBall(6);

        List<LottoBall> lottoBallList = List.of(
                lottoBall6,
                lottoBall1,
                lottoBall4,
                lottoBall2,
                lottoBall3,
                lottoBall5
        );
        LottoBalls lottoBalls = new LottoBalls(lottoBallList);

        assertThat(lottoBalls.getBalls()).containsExactly(
                lottoBall1,
                lottoBall2,
                lottoBall3,
                lottoBall4,
                lottoBall5,
                lottoBall6);
    }

    @ParameterizedTest
    @NullSource
    @MethodSource("getInvalidLottoBallList")
    @DisplayName("null 이거나 중복 로또볼, 혹은 로또볼 포함 수 를 만족못하는 리스트로 초기화 시 예외 발생.")
    void fail_to_init_lotto_balls_by_invalid_lotto_ball(List<LottoBall> lottoBallList) {
        assertThatExceptionOfType(InvalidLottoBallsException.class)
                .isThrownBy(() -> new LottoBalls(lottoBallList));
    }

    private static Stream<Arguments> getInvalidLottoBallList() {
        return Stream.of(
                Arguments.arguments(
                        List.of(
                                new LottoBall(1),
                                new LottoBall(2),
                                new LottoBall(1),
                                new LottoBall(4),
                                new LottoBall(5),
                                new LottoBall(6)
                        )
                ),
                Arguments.arguments(
                        List.of(
                                new LottoBall(1),
                                new LottoBall(2),
                                new LottoBall(3)
                        )
                )
        );
    }

}