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

  @DisplayName("WinningLotto와 비교하여 Rank를 구할 수 있다.")
  @ParameterizedTest
  @MethodSource("winningLottos")
  void getRank(WinningLotto winningLotto, Rank rank) {
    assertThat(lotto.getRank(winningLotto)).isEqualTo(rank);
  }

  private static Stream<Arguments> winningLottos() {
    WinningLotto matchThree = WinningLotto.create(Set.of(1, 2, 3, 30, 40, 45), 7);
    WinningLotto matchFour = WinningLotto.create(Set.of(1, 2, 3, 4, 40, 45), 7);
    WinningLotto matchFive = WinningLotto.create(Set.of(1, 2, 3, 4, 5, 45), 7);
    WinningLotto matchFiveAndBonus = WinningLotto.create(Set.of(1, 2, 3, 4, 5, 45), 6);
    WinningLotto matchSix = WinningLotto.create(Set.of(1, 2, 3, 4, 5, 6), 7);
    return Stream.of(
        Arguments.of(matchThree, Rank.FIFTH),
        Arguments.of(matchFour, Rank.FOURTH),
        Arguments.of(matchFive, Rank.THIRD),
        Arguments.of(matchFiveAndBonus, Rank.SECOND),
        Arguments.of(matchSix, Rank.FIRST)
    );
  }

  @DisplayName("String을 받아서 수동 로또를 생성할 수 있다.")
  @Test
  void manualCreate() {
    String input = "1, 2, 3, 4, 5, 6";
    assertThat(Lotto.manualCreate(input)).isEqualTo(lotto);
  }

  @DisplayName("로또를 생성할 수 없는 String이 들어오면 예외가 발생한다.")
  @ParameterizedTest
  @MethodSource("invalidInputAndExceptions")
  void manualCreate(String input, Class<Exception> e) {
    assertThatThrownBy(() -> Lotto.manualCreate(input)).isInstanceOf(e);
  }

  private static Stream<Arguments> invalidInputAndExceptions() {
    return Stream.of(
        Arguments.of("a, b, c, 1, 2, 3", NumberFormatException.class),
        Arguments.of("0, -1, 46, 1, 2, 3", IllegalArgumentException.class),
        Arguments.of("1, 2, 3, 4, 5", IllegalArgumentException.class)
    );
  }
}
