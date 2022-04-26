package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

  private Lotto lotto;

  @BeforeEach
  void setup() {
    lotto = new Lotto(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6)
    ));
  }

  @DisplayName("Integer Set을 받아 Lotto를 생성할 수 있다.")
  @Test
  void create() {
    Set<Integer> integers = Set.of(1, 2, 3, 4, 5, 6);
    assertThat(Lotto.create(integers)).isEqualTo(lotto);
  }

  @DisplayName("1~45 범위가 아닌 숫자가 포함되어있다면, 예외가 발생한다.")
  @Test
  void create_invalid_number() {
    Set<Integer> invalidNumbers = Set.of(-1, 0, 3, 4, 5, 46);
    assertThatThrownBy(() -> Lotto.create(invalidNumbers))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("두 로또의 일치하는 원소 개수로 Rank를 구할 수 있다.")
  @ParameterizedTest
  @MethodSource("lottos")
  void getRank(Lotto other, int matchCount) {
    assertThat(lotto.getRank(other)).isEqualTo(Rank.valueOf(matchCount));
  }

  private static Stream<Arguments> lottos() {
    Lotto matchThree = new Lotto(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(30),
        new LottoNumber(40),
        new LottoNumber(45)
    ));
    Lotto matchFour = new Lotto(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(40),
        new LottoNumber(45)
    ));
    Lotto matchFive = new Lotto(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(45)
    ));
    Lotto matchSix = new Lotto(Set.of(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6)
    ));
    return Stream.of(
        Arguments.of(matchThree, 3),
        Arguments.of(matchFour, 4),
        Arguments.of(matchFive, 5),
        Arguments.of(matchSix, 6)
    );
  }
}
