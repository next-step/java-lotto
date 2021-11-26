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
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinLottoTest {

    private final Lotto baseLotto = new Lotto("1, 2, 3, 4, 5, 6");

    @DisplayName("당첨 번호와 보너스가 중복되면 안됨")
    @Test
    void create() {
        assertDoesNotThrow(() -> new WinLotto(baseLotto, LottoNumber.valueOf(7)));
    }

    @DisplayName("당첨 번호와 보너스가 중복됨_실패")
    @Test
    void create_fail() {
        assertThatThrownBy(() -> new WinLotto(baseLotto, LottoNumber.valueOf(6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호와 보너스는 중복될 수 없습니다.");
    }

    @DisplayName("우승 번호로 당첨 순위를 확인")
    @ParameterizedTest
    @MethodSource(value = "provideLottos")
    void checkWinning(Lotto lotto, Rank rank, int matchCount) {
        Lotto winLotto = baseLotto;
        LottoNumber bonus = LottoNumber.valueOf(7);

        Ranks ranks = new WinLotto(winLotto, bonus).checkWinning(Arrays.asList(lotto));

        assertThat(ranks.countRankOf(rank)).isEqualTo(matchCount);
    }

    private static Stream<Arguments> provideLottos() {
        return Stream.of(
                Arguments.of(new Lotto("1, 2, 3, 4, 5, 6"), Rank.FIRST, 1),
                Arguments.of(new Lotto("1, 2, 3, 4, 5, 7"), Rank.SECOND, 1),
                Arguments.of(new Lotto("1, 2, 3, 4, 5, 8"), Rank.THIRD, 1),
                Arguments.of(new Lotto("1, 2, 3, 4, 8, 9"), Rank.FOURTH, 1),
                Arguments.of(new Lotto("1, 2, 3, 7, 8, 9"), Rank.FIFTH, 1),
                Arguments.of(new Lotto("1, 2, 7, 8, 9, 10"), Rank.ETC, 1)
        );
    }

}
