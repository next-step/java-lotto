package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.number.LottoNumber;
import step2.domain.number.LottoMatchingNumber;
import step2.domain.number.LottoNumbers;
import step2.domain.result.LottoMatchingResult;
import step2.util.Splitter;

import java.util.List;

public class LottosTest {

  @ParameterizedTest
  @DisplayName("추가 확인 및 개수 확인 테스트")
  @CsvSource(value = "1,2,3,4,5,6:2,4,6,8,10,12:2", delimiter = ':')
  void addLottoTest(String firstExpression, String secondExpression, int result) {
    Lottos lottos = new Lottos();
    List<LottoNumber> lottoNumbers = Splitter.split(firstExpression);
    Lotto firstLotto = new Lotto(new LottoNumbers(lottoNumbers));

    lottoNumbers = Splitter.split(secondExpression);
    Lotto secondLotto = new Lotto(new LottoNumbers(lottoNumbers));

    lottos.addLotto(firstLotto);
    lottos.addLotto(secondLotto);

    Assertions.assertThat(lottos.quantity().showCount()).isEqualTo(result);
  }

  @ParameterizedTest
  @DisplayName("일치 확인하는 지 체크")
  @CsvSource(value = {"1,2,3,4,5,6:2,4,6,8,10,12:3:1", "2,3,4,5,6,8:2,4,6,8,10,12:4:1", "11,13,15,17,20,25:11,13,15,12,20,25:5:1"}, delimiter = ':')
  void resultGetMatchingTest(String lotto, String answer, int targetCount, String result) {

    //setup source then target
    List<LottoNumber> lottoNumbers = Splitter.split(lotto);
    LottoNumbers sourceLottoNumbers = new LottoNumbers(lottoNumbers);

    lottoNumbers = Splitter.split(answer);
    LottoNumbers targetLottoNumbers = new LottoNumbers(lottoNumbers);

    Lotto source = new Lotto(sourceLottoNumbers);
    Lotto target = new Lotto(targetLottoNumbers);

    Lottos sourceLottos = new Lottos();
    sourceLottos.addLotto(source);

    LottoMatchingResult lottoMatchingResult = sourceLottos.matchLottos(target);
    Assertions.assertThat(lottoMatchingResult.toStringSpecificResult(new LottoMatchingNumber(targetCount))).isEqualTo(result);
  }
}
