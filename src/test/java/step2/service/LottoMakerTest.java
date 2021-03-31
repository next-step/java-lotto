package step2.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Lotto;
import step2.domain.number.Count;
import step2.domain.number.LottoNumber;
import step2.domain.number.LottoNumbers;
import step2.strategy.LottoStrategy;
import step2.util.Splitter;

import java.util.List;

class LottoMakerTest {

  LottoMaker lottoMaker;

  @BeforeEach
  void setup() {
    lottoMaker = new LottoMaker();
  }

  @ParameterizedTest
  @ValueSource(strings = "11,12,13,14,15,16")
  @DisplayName("정확한 로또 갯수대로 생성 테스트")
  void makeLottoTest(String strNumbers) {
    LottoNumbers result = new LottoNumbers(Splitter.split(strNumbers));
    Lotto targetLotto = new Lotto(result);
    LottoStrategy testStrategy = new LottoStrategy() {
      @Override
      public List<LottoNumber> markingNumbers(List<LottoNumber> lottoNumbers) {
        return Splitter.split(strNumbers);
      }
    };

    Assertions.assertThat(lottoMaker.makeLotto(testStrategy).matchLotto(targetLotto)).isEqualTo(new Count(6));
  }
}