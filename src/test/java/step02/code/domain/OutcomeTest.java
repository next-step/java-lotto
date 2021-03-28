package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OutcomeTest {
  @ParameterizedTest
  @MethodSource("lottosAndWinningNumberAndMatch")
  @DisplayName("lotto 와 지난주 당첨번호와 비교후 일치 갯수 리스트 테스트")
  public void match(Lottos lottos, String winningNumber, List<Integer> mustMatched) {
    Lotto winning = Lotto.makeLottoByString(winningNumber);
    Outcome outcome = new Outcome(0, lottos, winning);
    List<Integer> matched = outcome.match(winning.lotto());

    assertThat(matched)
      .hasSize(mustMatched.size())
      .hasSameElementsAs(mustMatched);
  }

  private static Stream<Arguments> lottosAndWinningNumberAndMatch() {
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
        Arrays.asList(6, 5, 5, 5, 6)
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
        Arrays.asList(4, 2, 1)
      )
    );
  }

  @ParameterizedTest
  @MethodSource("lottosAndWinningNumberAndResult")
  @DisplayName("lotto 와 지난주 번호와 비교후 map 형태로 일치갯수(key), 일치갯수 size(value) 가 맞게 생성되는지 테스트")
  public void result(Lottos lottos, String winningNumber, Map<Integer, Integer> mustResult) {
    Lotto winning = Lotto.makeLottoByString(winningNumber);
    Outcome outcome = new Outcome(0, lottos, winning);
    Map<Integer, Integer> result = outcome.statistic();

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
        Map.of(6, 2, 5, 3)
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
        Map.of(4, 1, 2, 1, 1, 1)
      )
    );
  }
}
