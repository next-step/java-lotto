package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.TestUtil.toNumbers;
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

  @DisplayName("객체 생성 실패 테스트 - 숫자가 6개가 아닐때")
  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
  void failTestConstruct(String givenNumbers) {
    List<LottoNumber> numbers = toNumbers(givenNumbers);
    assertThatThrownBy(() -> new LottoNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("다른 LottoNumbers와 비교해서 몇 개의 숫자가 동일한지 반환한다.")
  @ParameterizedTest
  @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,9,10:4", "1,4,11,7,40,6:3", "40,19,8,22,34,10:0"}, delimiter = ':')
  void matchTest(String givenNumbers, int expectation) {
    //given
    String givenWinnings = "1,2,3,4,5,6";
    LottoNumbers winningNumbers = new LottoNumbers(toNumbers(givenWinnings));
    List<LottoNumber> numbers = toNumbers(givenNumbers);

    //when & then
    assertThat(new LottoNumbers(numbers).match(winningNumbers)).isEqualTo(expectation);
  }
}
