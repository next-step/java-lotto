package lotto.domain;

import static lotto.domain.Lottos.PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

  static Stream<Arguments> multiComparingSource() {
    return Stream.of(
        arguments(
            Lists.list(
                new Lotto(new String[]{"1", "2", "3", "4", "5", "6"}),
                new Lotto(new String[]{"2", "5", "6", "8", "9", "20"})
            ),
            new Lotto(new String[]{"2", "5", "7", "8", "9", "13"}),
            Lists.list(2, 4)),
        arguments(
            Lists.list(
                new Lotto(new String[]{"45", "44", "43", "42", "41", "40"}),
                new Lotto(new String[]{"1", "2", "3", "4", "5", "6"})
            ),
            new Lotto(new String[]{"1", "2", "3", "4", "5", "6"}),
            Lists.list(0, 6))
    );
  }

  @Test
  @DisplayName("금액을 입력받아, 로또 금액으로 나눠 개수를 반환한다.")
  void create() {
    // given
    Money money = new Money(14000);
    long expectedSize = money.divideBy(PRICE).toInteger();

    // when
    Lottos lottos = new Lottos(money);

    // then
    assertThat(lottos.count()).isEqualTo(expectedSize);
  }

  @ParameterizedTest
  @DisplayName("여러개의 로또 번호를 받아서 당첨번호와 비교해 일치한 개수 목록을 반환한다.")
  @MethodSource("multiComparingSource")
  void compare(List<Lotto> lottoList, Lotto winningLotto, List<Integer> expected) {
    // given
    Lottos lottos = new Lottos(lottoList);

    // when
    List<Integer> matchCounts = lottos.compare(winningLotto);

    // then
    assertThat(matchCounts).isEqualTo(expected);
  }
}
