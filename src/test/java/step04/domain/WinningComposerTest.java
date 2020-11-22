package step04.domain;

import exception.ExistedInWinningLottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import step04.Rank;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningComposerTest {
    Lotto winningLotto;
    LottoBall bonusBall;
    Lottos lottos;

    @BeforeEach
    void setup() {
        winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusBall = LottoBall.valueOf(7);
        lottos = Lottos.of(Arrays.asList(
                Lotto.of(Arrays.asList(8, 21, 23, 41, 42, 43)),
                Lotto.of(Arrays.asList(3, 5, 11, 16, 32, 38)),
                Lotto.of(Arrays.asList(7, 11, 16, 35, 36, 44)),
                Lotto.of(Arrays.asList(1, 8, 11, 31, 41, 42)),
                Lotto.of(Arrays.asList(13, 14, 16, 38, 42, 45)),
                Lotto.of(Arrays.asList(7, 11, 30, 40, 42, 43)),
                Lotto.of(Arrays.asList(2, 13, 22, 32, 38, 45)),
                Lotto.of(Arrays.asList(23, 25, 33, 36, 39, 41)),
                Lotto.of(Arrays.asList(1, 3, 5, 14, 22, 45)),
                Lotto.of(Arrays.asList(5, 9, 38, 41, 43, 44)),
                Lotto.of(Arrays.asList(2, 8, 9, 18, 19, 21)),
                Lotto.of(Arrays.asList(13, 14, 18, 21, 23, 35)),
                Lotto.of(Arrays.asList(17, 21, 29, 37, 42, 45)),
                Lotto.of(Arrays.asList(3, 8, 27, 30, 35, 44))
        ));
    }

    @DisplayName("생성자")
    @Test
    void test_constructor() {
        assertThat(WinningComposer.of(winningLotto, bonusBall))
                .isEqualTo(WinningComposer.of(winningLotto, bonusBall));
    }

    private static Stream<LottoBall> provideInvalidBonusBallResult() {
        return Stream.of(
                LottoBall.valueOf(1),
                LottoBall.valueOf(2),
                LottoBall.valueOf(3),
                LottoBall.valueOf(4),
                LottoBall.valueOf(5),
                LottoBall.valueOf(6)
        );
    }

    @DisplayName("보너스 볼이 당첨로또에 포함되면 예외 던짐")
    @ParameterizedTest
    @MethodSource("provideInvalidBonusBallResult")
    void test_validateBonusBall() {
        assertThatExceptionOfType(ExistedInWinningLottoException.class)
                .isThrownBy(() -> WinningComposer.of(winningLotto, LottoBall.valueOf(1)));
    }

    @DisplayName("matching Count 계산")
    @Test
    void test_calculateCountOfMatch() {
        RankCounter expect = RankCounter.of();
        expect.put(Rank.valueOf(3, false), 1);
        expect.put(Rank.valueOf(0, false), 13);

        assertThat(WinningComposer.of(winningLotto, bonusBall).calculateMatchOfCount(lottos))
                .isEqualTo(expect);
    }

}
