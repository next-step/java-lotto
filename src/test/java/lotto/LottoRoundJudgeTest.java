package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.game.LottoWinType;
import lotto.domain.game.LottoWinningNumber;
import lotto.domain.round.LottoRoundJudge;
import lotto.domain.round.LottoRoundNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
      Arguments.of(new LottoRoundNumbers(List.of(1, 2, 3, 40, 41, 42)), LottoWinType.RANK_5),
      Arguments.of(new LottoRoundNumbers(List.of(1, 2, 3, 4, 41, 42)), LottoWinType.RANK_4),
      Arguments.of(new LottoRoundNumbers(List.of(1, 2, 3, 4, 5, 42)), LottoWinType.RANK_3),
      Arguments.of(new LottoRoundNumbers(List.of(1, 2, 3, 4, 5, 7)), LottoWinType.RANK_2),
      Arguments.of(new LottoRoundNumbers(List.of(1, 2, 3, 4, 5, 6)), LottoWinType.RANK_1),
      Arguments.of(new LottoRoundNumbers(List.of(45, 44, 43, 42, 41, 40)), LottoWinType.NONE)
    );
  }

  @ParameterizedTest(name = "LottoRoundJudge | {1} : 당첨번호 매칭 확인")
  @MethodSource("arguments")
  void 당첨번호_6개_중_N개_일치_테스트(LottoRoundNumbers given, LottoWinType expectedWinType) {
    // given
    LottoWinningNumber 당첨번호 = new LottoWinningNumber (Arrays.asList(1, 2, 3, 4, 5, 6), 7);

    // when
    LottoWinType judge = sut.judge(given, 당첨번호);

    // then
    Assertions.assertThat(judge)
        .isEqualTo(expectedWinType);
  }

  @DisplayName("LottoRoundJudge | 당첨기준에 만족하지 않으면 LottoWinType은 NONE 을 반환한다.")
  @Test
  void 당첨조건에_맞지_않는_구매번호() {
    // given
    LottoRoundNumbers  구매번호 = new LottoRoundNumbers(Arrays.asList(45, 44, 43, 42, 41, 40));
    LottoWinningNumber 당첨번호 = new LottoWinningNumber (Arrays.asList(1, 2, 3, 4, 5, 6), 7);

    // when
    LottoWinType judge = sut.judge(구매번호, 당첨번호);

    // then
    Assertions.assertThat(judge)
        .isEqualTo(LottoWinType.NONE);
  }
}
