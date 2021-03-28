package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class LottosTest {

  @Test
  @DisplayName("lotto 최소 구매 금액 이하인경우, lotto 구입후 잔액이 남은경우 에러 발생 테스트")
  public void check() {
    assertThatThrownBy(() -> {
      // 로또 최소 구매 금액 이하인경우
      new Lottos(500);
    }).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> {
      // 로또 구매후 잔액이 남는 경우
      new Lottos(1500);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @RepeatedTest(value = 100)
  @DisplayName("lotto 생성시, 최소값 1, 최대값 45 안의 6자리 숫자가 생성되는지 테스트")
  public void lottoNumber() {
    List<Number> lotto = new Lotto(new RandomNumber()).lotto();
    int min = lotto.stream().map(Number::number).min(Integer::compare).orElse(-1);
    int max = lotto.stream().map(Number::number).max(Integer::compare).orElse(46);

    assertThat(lotto.size()).isEqualTo(6);
    assertThat(min).isGreaterThan(0);
    assertThat(max).isLessThan(46);
  }

  @ParameterizedTest
  @CsvSource(value = {"1000:1", "15000:15"}, delimiter = ':')
  @DisplayName("구매 금액에 맞춰서 정확한 갯수의 lotto 가 생성되는지 테스트")
  public void buy(int money, int number) {
    List<Lotto> lottos = Lottos.buy(money);

    assertThat(lottos.size()).isEqualTo(number);
  }

  @ParameterizedTest
  @MethodSource("lottosAndWinningNumberAndMatch")
  @DisplayName("lotto 와 지난주 당첨번호와 비교후 일치 갯수 리스트 테스트")
  public void match(Lottos lottos, String winningNumber, List<Integer> mustMatched) {
    WinningNumber winning = WinningNumber.makeWinningNumberByString(winningNumber);
    List<Integer> matched = lottos.match(winning.number());

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
    WinningNumber winning = WinningNumber.makeWinningNumberByString(winningNumber);
    Map<Integer, Integer> result = lottos.result(winning.number());

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
