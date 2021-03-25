package lotto.domain;

import static lotto.domain.Rank.FIVE;
import static lotto.domain.Rank.FOUR;
import static lotto.domain.Rank.SIX;
import static lotto.domain.Rank.THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.Stream;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningStatisticsTest {

  static Stream<Arguments> winningStatisticsSource() {
    return Stream.of(
        Arguments.arguments(new Lottos(
                Lists.list(
                    new Lotto(new String[]{"1", "2", "3", "4", "5", "6"}), // SIX
                    new Lotto(new String[]{"1", "2", "3", "4", "5", "6"}), // SIX
                    new Lotto(new String[]{"1", "2", "3", "4", "5", "6"}), // SIX
                    new Lotto(new String[]{"2", "3", "4", "5", "6", "7"}), // FIVE
                    new Lotto(new String[]{"3", "4", "5", "6", "7", "8"}), // FOUR
                    new Lotto(new String[]{"4", "5", "6", "7", "8", "9"}), // THREE
                    new Lotto(new String[]{"5", "6", "7", "8", "9", "10"}) // NONE
                )
            ),
            new Lotto(new String[]{"1", "2", "3", "4", "5", "6"}),
            1L,
            1L,
            1L,
            3L,
            new Money(6000205000L)
        )
    );
  }

  @ParameterizedTest
  @DisplayName("로또목록과 당첨번호를 받아서 등수별로 개수를 계산하고, 합계금액도 반환할 수 있다.")
  @MethodSource("winningStatisticsSource")
  void create(Lottos lottos, Lotto winningLotto, long threeCount, long fourCount, long fiveCount, long sixCount,
      Money total) {
    // given
    // when
    WinningStatistics winningStatistics = new WinningStatistics(lottos, winningLotto);

    // then
    assertAll(
        () -> assertThat(winningStatistics.countOf(THREE)).isEqualTo(threeCount),
        () -> assertThat(winningStatistics.countOf(FOUR)).isEqualTo(fourCount),
        () -> assertThat(winningStatistics.countOf(FIVE)).isEqualTo(fiveCount),
        () -> assertThat(winningStatistics.countOf(SIX)).isEqualTo(sixCount),
        () -> assertThat(winningStatistics.totalMoney()).isEqualTo(total)
    );
  }
}
