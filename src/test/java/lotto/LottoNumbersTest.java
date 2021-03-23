package lotto;

import static lotto.LottoNumbers.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumbersTest {

  static Stream<String[]> winningNumbersSource() {
    return Stream.of(
        new String[]{"1, 2, 3, 4, 5, 6"},
        new String[]{"45, 44, 43, 42, 41, 40"}
    );
  }

  @Test
  @DisplayName("생성")
  void create() {
    assertThat(new LottoNumbers().size()).isEqualTo(LOTTO_NUMBER_COUNT);
  }

  @ParameterizedTest
  @DisplayName("당첨번호 목록을 입력받아 생성")
  @MethodSource("winningNumbersSource")
  void createWithWinningNumbers(String[] winningNumbers) {
    assertThat(new LottoNumbers(winningNumbers).size()).isEqualTo(LOTTO_NUMBER_COUNT);
  }
}
