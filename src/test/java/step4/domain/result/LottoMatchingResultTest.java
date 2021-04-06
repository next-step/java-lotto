package step4.domain.result;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.Cash;
import step4.domain.Lotto;
import step4.domain.Lottos;
import step4.domain.number.Count;
import step4.domain.number.LottoNumber;
import step4.domain.number.LottoNumbers;
import step4.util.Splitter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchingResultTest {

  @ParameterizedTest
  @DisplayName("일치 확인하는 지 체크")
  @CsvSource(value = {"1,2,3,4,5,6:2,4,6,8,10,12:2,4,6,41,42,43:45:false:3:2"}, delimiter = ':')
  void calcYieldTest(String lottoA, String lottoB, String targetLotto, int bonusBall, boolean bonusFlag, int matchingNumber, int count) {
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

    LottoMatchingResult lottoMatchingResult = sourceLottos.matchLottosWithBonusBall(target, new LottoNumber(bonusBall));
    Rank rank = Rank.findRankByCountOfMatch(matchingNumber, bonusFlag);
    assertThat(lottoMatchingResult.sendSpecificCount(rank)).isEqualTo(new Count(count));
  }

  @ParameterizedTest
  @DisplayName("수익률 체크")
  @CsvSource(value = {"1,2,3,4,5,6:2,4,6,8,10,12:2,4,6,41,42,43:14000:40:0.71"}, delimiter = ':')
  void calcYieldTest(String lottoA, String lottoB, String targetLotto, Long sellerMoney, int bonusBall, String result) {
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

    LottoMatchingResult lottoMatchingResult = sourceLottos.matchLottosWithBonusBall(target, new LottoNumber(bonusBall));
    Cash revenue = lottoMatchingResult.calcTotalRevenue();
    Assertions.assertThat(revenue.divideReturningString(new Cash(sellerMoney))).isEqualTo(result);
  }

  @ParameterizedTest
  @DisplayName("2등 찾는지 수익으로 체크")
  @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,5,7:6"}, delimiter = ':')
  void findingSecondRevenueTest(String lottoString, String targetString, int bonusBall) {
    Lotto boughtLotto = new Lotto(new LottoNumbers(Splitter.split(lottoString)));
    Lotto prizeLotto = new Lotto(new LottoNumbers(Splitter.split(targetString)));

    Lottos boughtLottos = new Lottos();
    boughtLottos.addLotto(boughtLotto);

    assertThat(
      boughtLottos.matchLottosWithBonusBall(prizeLotto, new LottoNumber(bonusBall)).calcTotalRevenue()
    ).isEqualTo(new Cash((long) Rank.SECOND.getWinningMoney()));
  }
}