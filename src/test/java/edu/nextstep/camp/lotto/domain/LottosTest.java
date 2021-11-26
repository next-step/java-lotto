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
        assertThat(testLottos.collect()).hasSameElementsAs(lottoList);
    }

    static Stream<Arguments> parseWinningResult() {
        return Stream.of(
                // 0 matched
                Arguments.of(
                        Lottos.of(List.of(Lotto.fromIntegers(List.of(10, 11, 12, 13, 14, 15)))),
                        GameResult.of(Ranks.of(List.of()))
                ),
                // 3 matched
                Arguments.of(
                        Lottos.of(List.of(Lotto.fromIntegers(List.of(1, 2, 3, 13, 14, 15)))),
                        GameResult.of(Ranks.of(List.of(Rank.FOURTH)))
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
                        GameResult.of(Ranks.of(List.of(Rank.FOURTH, Rank.FOURTH)))
                ),
                // 6 matched with 2 lottos
                Arguments.of(
                        Lottos.of(List.of(
                                Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)),
                                Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6))
                        )),
                        GameResult.of(Ranks.of(List.of(Rank.FIRST, Rank.FIRST)))
                )
        );
    }

    @ParameterizedTest(name = "check winning: {0} -> {1}")
    @MethodSource("parseWinningResult")
    public void winningResult(Lottos lottos, GameResult expected) {
        final Lotto winningNumber = Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottos.winningResult(winningNumber))
                .isEqualTo(expected);

    }
}
