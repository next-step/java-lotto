package step4.domain.number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.exception.InvalidNumbersSizeException;
import step4.util.Splitter;

class LottoNumbersTest {

  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,5"})
  @DisplayName("로또 숫자의 개수와 맞지 않을 때의 익셉션 호출 테스트")
  void lengthCheckTest(String lottoNumbers) {
    Assertions.assertThatThrownBy(() -> new LottoNumbers(Splitter.split(lottoNumbers)))
      .isInstanceOf(InvalidNumbersSizeException.class).hasMessage("숫자 개수가 일치하지 않습니다.");
  }

  @ParameterizedTest
  @CsvSource(value = {"1,2,3,4,5,6:2,4,6,8,10,12:44:3"}, delimiter = ':')
  @DisplayName("정확하게 일치 숫자의 개수를 확인하는지 테스트")
  void matchingResultTest(String boughtNum, String answerNum, int bonusBall, int result) {

    LottoNumbers pickedLottoNumbers = new LottoNumbers(Splitter.split(boughtNum));
    LottoNumbers prizeLottoNumbers = new LottoNumbers(Splitter.split(answerNum));
    Count resultCount = new Count(result);
    Assertions.assertThat(pickedLottoNumbers.matchNumbers(prizeLottoNumbers)).isEqualTo(resultCount);
  }

  @ParameterizedTest
  @CsvSource(value = {"27,5,18,2,44,35:2,5,18,27,35,44"}, delimiter = ':')
  @DisplayName("정렬 테스트")
  void sortTest(String boughtNum, String sortedNumbers) {

    LottoNumbers pickedLottoNumbers = new LottoNumbers(Splitter.split(boughtNum));
    LottoNumbers checkingLottoNumbers = new LottoNumbers(Splitter.split(sortedNumbers));

    pickedLottoNumbers.sort();

    Assertions.assertThat(pickedLottoNumbers.toString()).isEqualTo(checkingLottoNumbers.toString());
  }

  @ParameterizedTest
  @CsvSource(value = {"1,2,3,4,5,6:1:true", "1,2,3,4,5,6:7:false"}, delimiter = ':')
  @DisplayName("일치/불일치 확인하는지 테스트")
  void findSpecificMatchingTest(String boughtNum, int targetNumber, boolean result) {
    LottoNumbers pickedLottoNumbers = new LottoNumbers(Splitter.split(boughtNum));
    Assertions.assertThat(pickedLottoNumbers.matchSpecificNumber(new LottoNumber(targetNumber))).isEqualTo(result);
  }
}