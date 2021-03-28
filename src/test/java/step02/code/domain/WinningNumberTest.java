package step02.code.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberTest {
  
  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("winning number 에 들어가는 string 값이, null or empty 값의 경우, error 테스트")
  public void checkEmpty(String str) {
    assertThatThrownBy(() -> {
      WinningNumber.check(str);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {".fwe", "2f"})
  @DisplayName("winning number 에 들어가는 string 값이, 숫자가 아닌 경우, error 테스트")
  public void checkNumber(String str) {
    assertThatThrownBy(() -> {
      WinningNumber.check(str);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @MethodSource("winningNumberStringAndResult")
  @DisplayName("string 값으로 지난주 당첨번호가 의도한 값으로 생성되는지 테스트")
  public void make(String str, List<Integer> result) {
    WinningNumber winningNumber = WinningNumber.makeWinningNumberByString(str);

    assertThat(winningNumber.number()).isEqualTo(result);
  }

  private static Stream<Arguments> winningNumberStringAndResult() {
    return Stream.of(
      Arguments.of(
        "1, 2, 3, 4, 5, 6",
        Arrays.asList(1, 2, 3, 4, 5, 6)
      ),
      Arguments.of(
        "1, 2,3",
        Arrays.asList(1, 2, 3)
      )
    );
  }

}
