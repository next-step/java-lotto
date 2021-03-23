package lotto.domain;

import static lotto.domain.LottoNumbers.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

  static Stream<Arguments> winningNumbersSource() {
    return Stream.of(
        arguments((Object) new String[]{"1", "2", "3", "4", "5", "6"}),
        arguments((Object) new String[]{"45", "44", "43", "42", "41", "40"})
    );
  }

  static Stream<Arguments> comparingSource() {
    return Stream.of(
        arguments(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"2", "5", "7", "8", "9"}, 2),
        arguments(new String[]{"45", "44", "43", "42", "41", "40"}, new String[]{"1", "2", "3", "4", "5", "6"}, 0)
    );
  }

  static Stream<Arguments> multiComparingSource() {
    return Stream.of(
        arguments(
            new String[]{"1", "2", "3", "4", "5", "6"},
            new String[]{"2", "5", "6", "8", "9", "20"},
            new String[]{"2", "5", "7", "8", "9", "13"},
            2,
            4),
        arguments(
            new String[]{"45", "44", "43", "42", "41", "40"},
            new String[]{"1", "2", "3", "4", "5", "6"},
            new String[]{"1", "2", "3", "4", "5", "6"},
            0,
            6)
    );
  }

  @Test
  @DisplayName("로또 생성 테스트, 로또가 생성되면 지정된 갯수의 목록을 가진다.")
  void create() {
    assertThat(new Lotto().lottoNumbersSize()).isEqualTo(LOTTO_NUMBER_COUNT);
  }

  @ParameterizedTest
  @DisplayName("당첨번호 목록을 입력받아 로또 생성")
  @MethodSource("winningNumbersSource")
  void createWithWinningNumbers(String[] winningNumbers) {
    assertThat(new Lotto(winningNumbers).lottoNumbersSize()).isEqualTo(LOTTO_NUMBER_COUNT);
  }

  @ParameterizedTest
  @DisplayName("당첨번호와 비교해 일치한 갯수를 반환한다.")
  @MethodSource("comparingSource")
  void compare(String[] myNumbers, String[] winningNumbers, int expectedCount) {
    // given
    Lotto myLotto = new Lotto(myNumbers);
    Lotto winningLotto = new Lotto(winningNumbers);

    // when
    int matchCount = myLotto.compare(winningLotto);

    // then
    assertThat(matchCount).isEqualTo(expectedCount);
  }

  @ParameterizedTest
  @DisplayName("여러개의 번호를 당첨번호와 비교해 일치한 갯수를 반환한다.")
  @MethodSource("multiComparingSource")
  void compare(String[] myNumbers1, String[] myNumbers2, String[] winningNumbers, int expectedCount1,
      int expectedCount2) {
    // given
    Lotto myLotto1 = new Lotto(myNumbers1);
    Lotto myLotto2 = new Lotto(myNumbers2);
    Lotto winningLotto = new Lotto(winningNumbers);

    // when
    int matchCount1 = myLotto1.compare(winningLotto);
    int matchCount2 = myLotto2.compare(winningLotto);

    // then
    assertAll(
        () -> assertThat(matchCount1).isEqualTo(expectedCount1),
        () -> assertThat(matchCount2).isEqualTo(expectedCount2)
    );

  }
}
