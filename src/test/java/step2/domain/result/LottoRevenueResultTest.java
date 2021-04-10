package step2.domain.result;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Cash;
import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.number.LottoNumber;
import step2.domain.number.LottoNumbers;
import step2.util.Splitter;
import step2.util.StringUtil;

import java.util.List;

class LottoRevenueResultTest {
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

    LottoMatchingResult lottoMatchingResult = sourceLottos.matchLottos(target);
    LottoRevenueResult lottoRevenueResult = new LottoRevenueResult();
    Cash revenue = lottoRevenueResult.calcTotalRevenue(lottoMatchingResult);
    Double yield = revenue.divide(new Cash(sellerMoney));
    Assertions.assertThat(StringUtil.doubleToStringWithRounding(yield)).isEqualTo(result);
  }


}