package lotto.domain;

import lotto.domain.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @DisplayName("원하는 개수 만큼 로또 구입")
    @Test
    void create() {
        int lottoCount = 14;
        Lottos lottos = new Lottos(lottoCount);

        assertThat(lottos.getLottos()).hasSize(lottoCount);
    }

    @DisplayName("원하는 개수 만큼 로또 구입(음수_실패)")
    @Test
    void create_fail() {
        assertThatThrownBy(() -> new Lottos(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 개수는 0 미만일 수 없습니다.");
    }

    @DisplayName("우승 번호로 당첨 순위를 확인")
    @ParameterizedTest
    @MethodSource(value = "provideLottos")
    void checkWinning(Lotto lotto, Rank rank, int matchCount) {
        Lottos lottos = new Lottos(Arrays.asList(lotto));
        Lotto winLotto = new Lotto("1, 2, 3, 4, 5, 6");

        Ranks ranks = lottos.checkWinning(winLotto);

        assertThat(ranks.countRankOf(rank)).isEqualTo(matchCount);
    }

    private static Stream<Arguments> provideLottos() {
        return Stream.of(
                Arguments.of(new Lotto("1, 2, 3, 4, 5, 6"), Rank.FIRST, 1),
                Arguments.of(new Lotto("1, 2, 3, 4, 5, 7"), Rank.SECOND, 1),
                Arguments.of(new Lotto("1, 2, 3, 4, 7, 8"), Rank.THIRD, 1),
                Arguments.of(new Lotto("1, 2, 3, 7, 8, 9"), Rank.FOURTH, 1),
                Arguments.of(new Lotto("1, 2, 7, 8, 9, 10"), Rank.ETC, 1)
        );
    }

}
