package lotto.domain.reward;

import static lotto.domain.reward.LottoRank.FIFTH;
import static lotto.domain.reward.LottoRank.FIRST;
import static lotto.domain.reward.LottoRank.FOURTH;
import static lotto.domain.reward.LottoRank.NONE;
import static lotto.domain.reward.LottoRank.SECOND;
import static lotto.domain.reward.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.Lotto;

class WinningLottoTest {

    @Test
    @DisplayName("보너스 번호가 이미 로또 번호에 있는 번호인 경우 예외를 던진다.")
    void WinningLotto_LottoContainsBonusNumber_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(new int[] {1, 2, 3, 4, 5, 6}, 6));
    }

    @ParameterizedTest
    @MethodSource("lottos")
    @DisplayName("로또 번호와 보너스 번호를 바탕으로 당첨 순위를 반환한다.")
    void Match_LottoRank(final Lotto lotto, final LottoRank expectedRank) {
        final WinningLotto winningLotto = WinningLotto.of(new int[] {1, 2, 3, 4, 5, 6}, 7);

        assertThat(winningLotto.match(lotto))
                .isEqualTo(expectedRank);
    }

    private static Stream<Arguments> lottos() {
        return Stream.of(
                Arguments.of(Lotto.from(new int[] {1, 2, 3, 4, 5, 6}), FIRST),
                Arguments.of(Lotto.from(new int[] {1, 2, 3, 4, 5, 7}), SECOND),
                Arguments.of(Lotto.from(new int[] {1, 2, 3, 4, 5, 8}), THIRD),
                Arguments.of(Lotto.from(new int[] {1, 2, 3, 4, 7, 8}), FOURTH),
                Arguments.of(Lotto.from(new int[] {1, 2, 3, 7, 8, 9}), FIFTH),
                Arguments.of(Lotto.from(new int[] {1, 2, 7, 8, 9, 10}), NONE)
        );
    }
}
