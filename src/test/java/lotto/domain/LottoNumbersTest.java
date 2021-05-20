package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

  @DisplayName("객체 생성 & 동등성 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,5,6", "10,9,45,7,34,20"})
  void testConstruct(String givenNumbers) {
    List<LottoNumber> numbers = toNumbers(givenNumbers);
    assertThat(new LottoNumbers(numbers)).isEqualTo(new LottoNumbers(numbers));
  }

  @DisplayName("객체 생성 실패 테스트 - 숫자가 6개가 아닐때, 범위에서 벗어난 숫자가 포함되었을 때")
  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,5", "-1,2,3,4,5,6", "1,2,3,4,5,46"})
  void failTestConstruct(String givenNumbers) {
    List<LottoNumber> numbers = toNumbers(givenNumbers);
    assertThatThrownBy(() -> new LottoNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
  }

  private List<LottoNumber> toNumbers(String numbersString) {
    return Arrays.stream(numbersString.split(","))
        .map(numberString -> new LottoNumber(Integer.parseInt(numberString)))
        .collect(Collectors.toList());
  }

}
