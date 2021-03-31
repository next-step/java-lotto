package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.number.Count;
import step2.domain.number.LottoNumber;
import step2.domain.number.LottoNumbers;
import step2.util.Splitter;

import java.util.List;

class LottoResultTest {
  @ParameterizedTest
  @DisplayName("일치 확인하는 지 체크")
  @CsvSource(value = {"1,2,3,4,5,6:2,4,6,8,10,12:2,4,6,41,42,43:14000:0.71"}, delimiter = ':')
  void calcYieldTest(String lottoA, String lottoB, String targetLotto, int sellerMoney, String result) {
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

    LottoResult lottoResult = sourceLottos.matchLottos(target);
    lottoResult.calcYield(new Cash(sellerMoney));
    Assertions.assertThat(lottoResult.toStringYield()).isEqualTo(result);
  }


}