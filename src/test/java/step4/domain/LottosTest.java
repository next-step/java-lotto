package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.number.LottoNumber;
import step4.domain.number.LottoNumbers;
import step4.domain.result.LottoMatchingResult;
import step4.domain.result.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
  @ParameterizedTest
  @DisplayName("추가 확인 및 개수 확인 테스트")
  @CsvSource(value = "1,2,3,4,5,6:2,4,6,8,10,12:2", delimiter = ':')
  void addLottoTest(String firstExpression, String secondExpression, int result) {
    Lotto firstLotto = new Lotto(new LottoNumbers(firstExpression));
    Lotto secondLotto = new Lotto(new LottoNumbers(secondExpression));

    Lottos lottos = new Lottos.Builder()
      .add(firstLotto)
      .add(secondLotto)
      .build();

    assertThat(lottos.quantity().showCount()).isEqualTo(result);
  }

  @ParameterizedTest
  @DisplayName("일치 확인하는 지 체크")
  @CsvSource(value = {"1,2,3,4,5,6:2,4,6,8,10,12:44:3:false:1", "2,3,4,5,6,8:2,4,6,8,10,12:44:4:false:1", "11,13,15,17,20,25:11,13,15,12,20,25:44:5:false:1"}, delimiter = ':')
  void resultGetMatchingTest(String lotto, String answer, int bonusBall, int targetCount, boolean targetFlag, String result) {

    //setup source then target
    Lotto source = new Lotto(new LottoNumbers(lotto));
    Lotto target = new Lotto(new LottoNumbers(answer));

    Lottos sourceLottos = new Lottos.Builder()
      .add(source)
      .build();

    Rank rank = Rank.findRankByCountOfMatch(targetCount, targetFlag);

    LottoMatchingResult lottoMatchingResult = sourceLottos.matchLottosWithBonusBall(target, new LottoNumber(bonusBall));
    assertThat(
      lottoMatchingResult
        .toStringSpecificResult(rank)
    ).isEqualTo(result);
  }

  @ParameterizedTest
  @DisplayName("두 로또 합 테스트")
  @CsvSource(value = {"1,2,3,4,5,6:2,4,6,8,10,12:2", "2,3,4,5,6,8:2,4,6,8,10,12:2", "11,13,15,17,20,25:11,13,15,12,20,25:2"}, delimiter = ':')
  void lottosMergeTest(String lotto, String answer, int result) {
    //setup source then target

    Lotto source = new Lotto(new LottoNumbers(lotto));
    Lottos sourceLottos = new Lottos.Builder()
      .add(source)
      .build();

    Lotto target = new Lotto(new LottoNumbers(answer));
    Lottos targetLottos = new Lottos.Builder()
      .add(target)
      .build();

    assertThat(
      sourceLottos
        .mergeLottos(targetLottos)
        .quantity()
        .showCount()
    ).isEqualTo(result);
  }
}
