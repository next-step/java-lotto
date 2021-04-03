package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.number.Count;
import step3.domain.number.LottoMatchingNumber;
import step3.domain.number.LottoNumbers;
import step3.util.Splitter;

public class LottoTest {

  @ParameterizedTest
  @CsvSource(value = {"1,2,3,4,5,6:2,4,6,8,10,12:3"}, delimiter = ':')
  @DisplayName("정확하게 일치 숫자의 개수를 확인하는지 테스트")
  void matchingResultTest(String boughtNum, String answerNum, int result) {
    LottoNumbers lottoNumbers = new LottoNumbers(Splitter.split(boughtNum));
    Lotto boughtLotto = new Lotto(lottoNumbers);

    lottoNumbers = new LottoNumbers(Splitter.split(answerNum));
    Lotto pickedLotto = new Lotto(lottoNumbers);

    Count resultCount = new LottoMatchingNumber(result);

    Assertions.assertThat(boughtLotto.matchLotto(pickedLotto)).isEqualTo(resultCount);
  }
}
