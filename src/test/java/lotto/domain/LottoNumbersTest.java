package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.util.TestUtil.toNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

  @DisplayName("로또 숫자의 갯수는 6개여야 한다.")
  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
  void failTestConstruct(String givenNumbers) {
    List<LottoNumber> numbers = toNumbers(givenNumbers);
    assertThatThrownBy(() -> new LottoNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호와 비교해서 몇 개의 숫자가 동일한지 반환한다.")
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

  @DisplayName("특정 번호가 포함되어있는지 여부를 반환한다.")
  @ParameterizedTest
  @CsvSource(value = {"1,2,3,4,5,6:true", "40,19,8,22,34,10:false"}, delimiter = ':')
  void containsTest(String givenNumbers, boolean expectation) {
    //given
    LottoNumber givenNumber = new LottoNumber(6);
    List<LottoNumber> numbers = toNumbers(givenNumbers);

    //when & then
    assertThat(new LottoNumbers(numbers).contains(givenNumber)).isEqualTo(expectation);
  }
}
