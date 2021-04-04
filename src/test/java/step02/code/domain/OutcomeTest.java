package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OutcomeTest {
  @ParameterizedTest
  @MethodSource("lottosAndWinningNumberAndResult")
  @DisplayName("lotto 와 지난주 번호와 비교후 map 형태로 일치갯수(key), 일치갯수 size(value)")
  public void result(Lottos lottos, String winningNumber, Number bonus, Map<GradeEnum, Integer> mustResult) {
    Lotto winning = Lotto.makeLottoByString(winningNumber);
    Outcome outcome = new Outcome(0, lottos);
    Map<GradeEnum, Integer> result = outcome.statistic(winning, bonus);

    assertThat(result.equals(mustResult)).isTrue();
  }

  private static Stream<Arguments> lottosAndWinningNumberAndResult() {
    return Stream.of(
      Arguments.of(
        new Lottos(
          Arrays.asList(
            new Lotto(Arrays.asList(1,2,3,4,5,6)),
            new Lotto(Arrays.asList(1,2,3,4,5,6)),
            new Lotto(Arrays.asList(1,2,3,4,5,7)),
            new Lotto(Arrays.asList(1,2,3,4,5,7)),
            new Lotto(Arrays.asList(1,2,3,4,5,7))
          )
        ),
        "1,2,3,4,5,6",
        new Number(7),
        Map.of(GradeEnum.FIRST, 2, GradeEnum.SECOND, 3)
      ),
      Arguments.of(
        new Lottos(
          Arrays.asList(
            new Lotto(Arrays.asList(1,2,41,42,43,44)),
            new Lotto(Arrays.asList(1,2,3,4,43,44)),
            new Lotto(Arrays.asList(1,2,3,4,5,45))
          )
        ),
        "40,41,42,43,44,45",
        new Number(7),
        Map.of(GradeEnum.FOURTH, 1, GradeEnum.NONE, 2)
      )
    );
  }
}
