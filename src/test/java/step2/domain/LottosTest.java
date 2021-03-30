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

public class LottosTest {
  @ParameterizedTest
  @DisplayName("일치 확인하는 지 체크")
  @CsvSource(value = {"1,2,3,4,5,6:2,4,6,8,10,12:3:1", "2,3,4,5,6,8:2,4,6,8,10,12:4:1"}, delimiter = ':')
  void resultGetMatchingTest(String lotto, String answer, int targetCount, String result){

    //setup source then target
    List<LottoNumber> lottoNumbers = Splitter.split(lotto);
    LottoNumbers sourceLottoNumbers = new LottoNumbers(lottoNumbers);

    lottoNumbers = Splitter.split(answer);
    LottoNumbers targetLottoNumbers = new LottoNumbers(lottoNumbers);

    Lotto source = new Lotto(sourceLottoNumbers);
    Lotto target = new Lotto(targetLottoNumbers);

    Lottos sourceLottos = new Lottos();
    sourceLottos.addLotto(source);

    LottoResult lottoResult = sourceLottos.matchLottos(target);
    System.out.println(lottoResult);
    Assertions.assertThat(lottoResult.toStringSpecificResult(new Count(targetCount))).isEqualTo(result);
  }

}
