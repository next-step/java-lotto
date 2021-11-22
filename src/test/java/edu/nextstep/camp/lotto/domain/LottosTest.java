package edu.nextstep.camp.lotto.domain;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottosTest {
    @Test
    public void create() {
        final Lotto testLotto = Lotto.of(
                List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
        );
        assertThat(Lottos.of(List.of(testLotto)))
                .isEqualTo(Lottos.of(List.of(
                        Lotto.of(
                                List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
                        )
                )));
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullAndEmptySource
    public void createFailed(List<Lotto> lottos) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottos.of(lottos))
                .withMessageContaining("invalid input");
    }

    @Test
    public void amount() {
        final Lottos testLottos = Lottos.of(List.of(
                        Lotto.of(
                                List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                        LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
                        )
                ));
        assertThat(testLottos.amount()).isEqualTo(1);

    }

    static Stream<Arguments> parseWinningResult() {
        return Stream.of(
                // 0 matched
                Arguments.of(
                        Lotto.of(List.of(LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12),
                                LottoNumber.of(13), LottoNumber.of(14), LottoNumber.of(15))),
                        GameResult.of(0, 0, 0, 0)
                ),
                // 1 matched
                Arguments.of(
                        Lotto.of(List.of(LottoNumber.of(1), LottoNumber.of(11), LottoNumber.of(12),
                                LottoNumber.of(13), LottoNumber.of(14), LottoNumber.of(15))),
                        GameResult.of(0, 0, 0, 0)
                ),
                // 2 matched
                Arguments.of(
                        Lotto.of(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(12),
                                LottoNumber.of(13), LottoNumber.of(14), LottoNumber.of(15))),
                        GameResult.of(0, 0, 0, 0)
                ),
                // 3 matched
                Arguments.of(
                        Lotto.of(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(13), LottoNumber.of(14), LottoNumber.of(15))),
                        GameResult.of(0, 0, 0, 1)
                ),
                // 4 matched
                Arguments.of(
                        Lotto.of(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(14), LottoNumber.of(15))),
                        GameResult.of(0, 0, 1, 0)
                ),
                // 5 matched
                Arguments.of(
                        Lotto.of(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(15))),
                        GameResult.of(0, 1, 0, 0)
                ),
                // 6 matched
                Arguments.of(
                        Lotto.of(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))),
                        GameResult.of(1, 0, 0, 0)
                )
        );
    }

    @ParameterizedTest(name = "check winning: {0} -> {1}")
    @MethodSource("parseWinningResult")
    public void winningResult(Lotto winningNumber, GameResult expected) {
        final Lottos testLottos = Lottos.of(List.of(
                Lotto.of(
                        List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
                )
        ));
        assertThat(testLottos.winningResult(winningNumber))
                .isEqualTo(expected);

    }
}
