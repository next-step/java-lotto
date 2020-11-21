package step03.domain;

import exception.ExistedInWinningLottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningLottoTest {
    Lotto winningLotto;

    @BeforeEach
    void setup() {
        winningLotto = Lotto.intOf(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("생성자")
    @Test
    void test_constructor() {
        BonusBall bonusBall = BonusBall.of(LottoBall.valueOf(7));
        assertThat(WinningLotto.of(winningLotto, bonusBall))
                .isEqualTo(WinningLotto.of(winningLotto, bonusBall));
    }

    private static Stream<BonusBall> provideInvalidBonusBallResult() {
        return Stream.of(
                BonusBall.of(LottoBall.valueOf(1)),
                BonusBall.of(LottoBall.valueOf(2)),
                BonusBall.of(LottoBall.valueOf(3)),
                BonusBall.of(LottoBall.valueOf(4)),
                BonusBall.of(LottoBall.valueOf(5)),
                BonusBall.of(LottoBall.valueOf(6))
        );
    }

    @DisplayName("보너스 볼이 당첨로또에 포함되면 예외 던짐")
    @ParameterizedTest
    @MethodSource("provideInvalidBonusBallResult")
    void test_validateBonusBall(BonusBall bonusBall) {
        assertThatExceptionOfType(ExistedInWinningLottoException.class)
                .isThrownBy(() -> {
                    WinningLotto.of(winningLotto, bonusBall);
                });
    }


}
