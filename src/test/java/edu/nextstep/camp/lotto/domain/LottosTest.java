package edu.nextstep.camp.lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import static edu.nextstep.camp.lotto.domain.LottoTest.lotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottosTest {
    static Stream<Arguments> parseCreate() {
        return Stream.of(
                Arguments.of(List.of(lotto(1, 2, 3, 4, 5, 6)))
        );
    }
    @ParameterizedTest(name = "create: {arguments}")
    @EmptySource
    @MethodSource("parseCreate")
    public void create(List<Lotto> lottos) {
        assertThat(Lottos.of(lottos))
                .isEqualTo(Lottos.of(lottos));
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullSource
    public void createFailed(List<Lotto> lottos) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lottos.of(lottos))
                .withMessageContaining("invalid input");
    }

    @Test
    public void createEmpty() {
        assertThat(Lottos.empty().collect()).isEmpty();
        assertThat(Lottos.of(Collections.emptyList()).collect()).isEmpty();
        assertThat(Lottos.empty() == Lottos.of(Collections.emptyList())).isTrue();
    }

    @Test
    public void amount() {
        assertThat(lottos(lotto(1, 2, 3, 4, 5, 6)).amount()).isEqualTo(1);
    }

    @Test
    public void collect() {
        assertThat(lottos(lotto(1, 2, 3, 4, 5, 6)).collect()).hasSameElementsAs(List.of(lotto(1, 2, 3, 4, 5, 6)));
    }

    static Stream<Arguments> parseWinningResult() {
        return Stream.of(
                // 0 matched
                Arguments.of(
                        lottos(lotto(10, 11, 12, 13, 14, 15)),
                        GameResult.of(List.of(Rank.NO_RANK))
                ),
                // 3 matched
                Arguments.of(
                        lottos(lotto(1, 2, 3, 13, 14, 15)),
                        GameResult.of(List.of(Rank.FIFTH))
                ),
                // 6 matched
                Arguments.of(
                        lottos(lotto(1, 2, 3, 4, 5, 6)),
                        GameResult.of(List.of(Rank.FIRST))
                ),
                // 3 matched with 2 lottos
                Arguments.of(
                        lottos(lotto(1, 2, 3, 13, 14, 15), lotto(1, 2, 3, 13, 14, 15)),
                        GameResult.of(List.of(Rank.FIFTH, Rank.FIFTH))
                ),
                // 6 matched with 2 lottos
                Arguments.of(
                        lottos(lotto(1, 2, 3, 4, 5, 6), lotto(1, 2, 3, 4, 5, 6)),
                        GameResult.of(List.of(Rank.FIRST, Rank.FIRST))
                ),
                // 5 matched with bonus matched
                Arguments.of(
                        lottos(lotto(1, 2, 3, 4, 5, 7)),
                        GameResult.of(List.of(Rank.SECOND))
                ),
                // 5 matched
                Arguments.of(
                        lottos(lotto(1, 2, 3, 4, 5, 15)),
                        GameResult.of(List.of(Rank.THIRD))
                ),
                // 4 matched
                Arguments.of(
                        lottos(lotto(1, 2, 3, 4, 14, 15)),
                        GameResult.of(List.of(Rank.FOURTH))
                )
        );
    }

    @ParameterizedTest(name = "check winning: {0} -> {1}")
    @MethodSource("parseWinningResult")
    public void winningResult(Lottos lottos, GameResult expected) {
        final WinningNumber winningNumber = WinningNumber.of(Set.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottos.winningResult(winningNumber)).isEqualTo(expected);
    }

    @Test
    public void append() {
        Lotto manualLotto = lotto(1, 2, 3, 4, 5, 6);
        Lotto autoLotto = lotto(11, 12, 13, 14, 15, 16);
        assertThat(lottos(manualLotto).append(lottos(autoLotto)).amount()).isEqualTo(2);
        assertThat(lottos(manualLotto).append(lottos(autoLotto)).collect()).containsExactly(manualLotto, autoLotto);
    }

    public static Lottos lottos(Lotto ... lottos) {
        return Lottos.of(Arrays.asList(lottos));
    }
}
