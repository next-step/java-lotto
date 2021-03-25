package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
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
  @DisplayName("lotto 구입금액이 올바르지 않을 경우 예외처리 테스트")
  public void check() {
    assertThatThrownBy(() -> {
      // 로또 최소 구매 금액 이하인경우
      Lottos.check(500);
    }).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> {
      // 로또 구매후 잔액이 남는 경우
      Lottos.check(1500);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @RepeatedTest(value = 100)
  @DisplayName("lotto number 생성 테스트")
  public void lottoNumber() {
    List<Integer> lotto = Lottos.lottoNumbers(new RandomNumber());
    int min = lotto.stream().min(Integer::compare).orElse(-1);
    int max = lotto.stream().max(Integer::compare).orElse(46);

    assertThat(lotto.size()).isEqualTo(6);
    assertThat(min).isGreaterThan(0);
    assertThat(max).isLessThan(46);
  }

  @ParameterizedTest
  @CsvSource(value = {"1000:1", "15000:15"}, delimiter = ':')
  @DisplayName("구매 금액에 맞춰서 정확한 갯수의 로또가 구매되는지 테스트")
  public void buy(int money, int number) {
    List<Lotto> lottos = Lottos.buy(money);

    assertThat(lottos.size()).isEqualTo(number);
  }

  @ParameterizedTest
  @MethodSource("lottosAndWinningNumberAndMatch")
  @DisplayName("winning number 와 비교해 맞는갯수를 담은 list 가 return 되는지 테스트")
  public void match(Lottos lottos, List<Integer> winningNumber, List<Integer> mustMatched) {
    List<Integer> matched = lottos.match(winningNumber);

    assertThat(matched.size()).isEqualTo(mustMatched.size());
    assertThat(matched).hasSameElementsAs(mustMatched);
  }

  private static Stream<Arguments> lottosAndWinningNumberAndMatch() {
    return Stream.of(
      Arguments.of(
        new Lottos(
          Arrays.asList(
            new Lotto(Arrays.asList(1,2,3,4,5,6)),
            new Lotto(Arrays.asList(1,2,3,4,5,7))
          )
        ),
        Arrays.asList(1, 2, 3, 4, 5, 6),
        Arrays.asList(6, 5)
      ),
      Arguments.of(
        new Lottos(
          Arrays.asList(
            new Lotto(Arrays.asList(1,2,41,42,43,44)),
            new Lotto(Arrays.asList(1,2,3,4,43,44)),
            new Lotto(Arrays.asList(1,2,3,4,5,45))
          )
        ),
        Arrays.asList(40, 41, 42, 43, 44, 45),
        Arrays.asList(4, 2, 1)
      )
    );
  }
}
