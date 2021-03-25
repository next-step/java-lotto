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
            1,
            1,
            1,
            3
        )
    );
  }

  @ParameterizedTest
  @DisplayName("로또목록과 당첨번호를 받아서 등수별로 개수를 계산한다.")
  @MethodSource("winningStatisticsSource")
  void create(Lottos lottos, Lotto winningLotto, int threeCount, int fourCount, int fiveCount, int sixCount) {
    // given
    // when
    WinningStatistics winningStatistics = new WinningStatistics(lottos, winningLotto);

    // then
    assertAll(
        () -> assertThat(winningStatistics.countOf(THREE)).isEqualTo(threeCount),
        () -> assertThat(winningStatistics.countOf(FOUR)).isEqualTo(fourCount),
        () -> assertThat(winningStatistics.countOf(FIVE)).isEqualTo(fiveCount),
        () -> assertThat(winningStatistics.countOf(SIX)).isEqualTo(sixCount)
    );
  }
}
