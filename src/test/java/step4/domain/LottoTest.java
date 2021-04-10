package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.number.Count;
import step4.domain.number.LottoNumbers;

public class LottoTest {

  @ParameterizedTest
  @CsvSource(value = {"1,2,3,4,5,6:2,4,6,8,10,12:3"}, delimiter = ':')
  @DisplayName("정확하게 일치 숫자의 개수를 확인하는지 테스트")
  void matchingResultTest(String boughtNum, String answerNum, int result) {
    Lotto boughtLotto = new Lotto(new LottoNumbers(boughtNum));
    Lotto pickedLotto = new Lotto(new LottoNumbers(answerNum));

    Count resultCount = new Count(result);

    Assertions.assertThat(boughtLotto.matchLotto(pickedLotto)).isEqualTo(resultCount);
  }
}
