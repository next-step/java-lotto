package lotto;

import static lotto.LottoNumbers.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
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
}
