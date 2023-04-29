package lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import lotto.domain.game.LottoWinType;
import lotto.domain.round.LottoRoundJudge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoRoundJudgeTest {

  private LottoRoundJudge sut;

  @BeforeEach
  void setup() {
    sut = new LottoRoundJudge();
  }

  private static Stream<Arguments> arguments () {
    return Stream.of (
      Arguments.of(List.of(1, 2, 3, 40, 41, 42), LottoWinType.RANK_4),
      Arguments.of(List.of(1, 2, 3, 4, 41, 42), LottoWinType.RANK_3),
      Arguments.of(List.of(1, 2, 3, 4, 5, 42), LottoWinType.RANK_2),
      Arguments.of(List.of(1, 2, 3, 4, 5, 6), LottoWinType.RANK_1)
    );
  }

  @DisplayName("LottoRoundJudge | 당첨번호 6개중 n개가 일치하는지 테스트 한다.")
  @ParameterizedTest(name = "{index}. {0}인 경우, {1}")
  @MethodSource("arguments")
  void 당첨번호_6개_중_N개_일치_테스트(List<Integer> given, LottoWinType expectedWinType) {
    // given
    List<Integer> 당첨번호 = List.of(1, 2, 3, 4, 5, 6);

    // when
    LottoWinType judge = sut.judge(given, 당첨번호);

    // then
    Assertions.assertThat(judge)
        .isEqualTo(expectedWinType);
  }
}
