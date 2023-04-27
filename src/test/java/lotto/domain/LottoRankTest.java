package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
  @Test
  @DisplayName("로또 일치 개수 리스트 반환 테스트")
  public void create_로또_일치_개수_리스트() {
    assertThat(LottoRank.lottoMatchedNumberList()).contains(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FIFTH);
  }

  @ParameterizedTest(name = "일치하는 개수에 따라 상금 반환 테스트")
  @MethodSource("provide_일치하는_개수에_따른_상금_반환")
  public void 일치하는_개수에_따른_상금_반환(int input, boolean matchBonus, int expected) {
    LottoRank lottoRank = LottoRank.valueOfMatchedCount(input, matchBonus);

    assertThat(lottoRank.prizeMoney()).isEqualTo(expected);
  }

  @Test
  @DisplayName("2등 반환 테스트")
  public void create_2등() {
    LottoRank lottoRank = LottoRank.valueOfMatchedCount(5, true);

    assertThat(lottoRank.prizeMoney()).isEqualTo(30_000_000);
  }

  private static Stream<Arguments> provide_일치하는_개수에_따른_상금_반환() {
    return Stream.of(
            Arguments.arguments(6, false, 2_000_000_000),
            Arguments.arguments(5, true, 30_000_000),
            Arguments.arguments(5, false, 1_500_000),
            Arguments.arguments(4, false, 50_000),
            Arguments.arguments(3, false, 5_000),
            Arguments.arguments(2, true, 0)
    );
  }
}
