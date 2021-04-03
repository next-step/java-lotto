package step2.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.number.Count;
import step2.domain.number.LottoNumber;
import step2.domain.number.LottoMatchingNumber;
import step2.domain.number.LottoNumbers;
import step2.util.Splitter;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

class LottoMatchingResultTest {

  @ParameterizedTest
  @DisplayName("일치 확인하는 지 체크")
  @CsvSource(value = {"1,2,3,4,5,6:2,4,6,8,10,12:2,4,6,41,42,43:3:2"}, delimiter = ':')
  void calcYieldTest(String lottoA, String lottoB, String targetLotto, int matchingNumber, int count) {
    //setup source then target
    List<LottoNumber> lottoNumbers = Splitter.split(lottoA);
    LottoNumbers aLottoNumbers = new LottoNumbers(lottoNumbers);
    lottoNumbers = Splitter.split(lottoB);
    LottoNumbers bLottoNumbers = new LottoNumbers(lottoNumbers);
    lottoNumbers = Splitter.split(targetLotto);
    LottoNumbers targetLottoNumbers = new LottoNumbers(lottoNumbers);

    Lotto aLotto = new Lotto(aLottoNumbers);
    Lotto bLotto = new Lotto(bLottoNumbers);
    Lotto target = new Lotto(targetLottoNumbers);

    Lottos sourceLottos = new Lottos();
    sourceLottos.addLotto(aLotto);
    sourceLottos.addLotto(bLotto);

    LottoMatchingResult lottoMatchingResult = sourceLottos.matchLottos(target);
    assertThat(lottoMatchingResult.sendSpecificCount(new LottoMatchingNumber(matchingNumber))).isEqualTo(new Count(count));
  }
}