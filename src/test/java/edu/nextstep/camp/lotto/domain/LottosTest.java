package edu.nextstep.camp.lotto.domain;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
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
        final Lotto testLotto = Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(Lottos.of(List.of(testLotto)))
                .isEqualTo(Lottos.of(List.of(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)))));
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
        final Lottos testLottos = Lottos.of(List.of(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6))));
        assertThat(testLottos.amount()).isEqualTo(1);
    }

    @Test
    public void collect() {
        final List<Lotto> lottoList = List.of(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)));
        final Lottos testLottos = Lottos.of(lottoList);
        assertThat(testLottos.collect()).hasSameElementsAs(List.of(List.of("1", "2", "3", "4", "5", "6")));
    }

    static Stream<Arguments> parseWinningResult() {
        return Stream.of(
                // 0 matched
                Arguments.of(
                        Lottos.of(List.of(Lotto.fromIntegers(List.of(10, 11, 12, 13, 14, 15)))),
                        GameResult.of(Ranks.of(List.of(Rank.NO_RANK)))
                ),
                // 3 matched
                Arguments.of(
                        Lottos.of(List.of(Lotto.fromIntegers(List.of(1, 2, 3, 13, 14, 15)))),
                        GameResult.of(Ranks.of(List.of(Rank.FIFTH)))
                ),
                // 6 matched
                Arguments.of(
                        Lottos.of(List.of(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)))),
                        GameResult.of(Ranks.of(List.of(Rank.FIRST)))
                ),
                // 3 matched with 2 lottos
                Arguments.of(
                        Lottos.of(List.of(
                                Lotto.fromIntegers(List.of(1, 2, 3, 13, 14, 15)),
                                Lotto.fromIntegers(List.of(1, 2, 3, 13, 14, 15))
                        )),
                        GameResult.of(Ranks.of(List.of(Rank.FIFTH, Rank.FIFTH)))
                ),
                // 6 matched with 2 lottos
                Arguments.of(
                        Lottos.of(List.of(
                                Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)),
                                Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6))
                        )),
                        GameResult.of(Ranks.of(List.of(Rank.FIRST, Rank.FIRST)))
                ),
                // 5 matched with bonus matched
                Arguments.of(
                        Lottos.of(List.of(
                                Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 7))
                        )),
                        GameResult.of(Ranks.of(List.of(Rank.SECOND)))
                ),
                // 5 matched
                Arguments.of(
                        Lottos.of(List.of(
                                Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 15))
                        )),
                        GameResult.of(Ranks.of(List.of(Rank.THIRD)))
                ),
                // 4 matched
                Arguments.of(
                        Lottos.of(List.of(
                                Lotto.fromIntegers(List.of(1, 2, 3, 4, 14, 15))
                        )),
                        GameResult.of(Ranks.of(List.of(Rank.FOURTH)))
                )
        );
    }

    @ParameterizedTest(name = "check winning: {0} -> {1}")
    @MethodSource("parseWinningResult")
    public void winningResult(Lottos lottos, GameResult expected) {
        final Lotto winningNumber = Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6));
        final LottoNumber bonus = LottoNumber.of(7);
        assertThat(lottos.winningResult(winningNumber, bonus)).isEqualTo(expected);
    }

    @Test
    @DisplayName("check winning result failed due to bonus is in winning number")
    public void winningResultFailed() {
        final Lottos lottos = Lottos.of(List.of(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6))));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottos.winningResult(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(1)))
                .withMessageContaining("winning number and bonus number must be exclusive");
    }
}
