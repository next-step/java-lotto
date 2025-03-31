package lotto.type;

import lotto.strategy.LottoCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class LottoNumberTest {

  @DisplayName("생성자 테스트")
  @Test
  void constructorTest1() {
    assertAll(
        () -> assertDoesNotThrow(() -> new LottoNumber(1)),
        () -> assertDoesNotThrow(() -> new LottoNumber(45)),
        () -> assertThrows(RuntimeException.class, () -> new LottoNumber(-1)),
        () -> assertThrows(RuntimeException.class, () -> new LottoNumber(46))
    );
  }

  @DisplayName("랜덤 로또숫자 생성")
  @Test
  void constructorTest2() {
    LottoCreateStrategy lottoCreateStrategyStub = new LottoCreateStrategy() {
      @Override
      public int pick(int min, int max) {
        return 1;
      }

      @Override
      public List<LottoNumber> shuffle(List<LottoNumber> lottoNumbers) {
        return lottoNumbers;
      }
    };

    assertThat(LottoNumber.createRandomNumber(lottoCreateStrategyStub)).isEqualTo(new LottoNumber(1));
  }
}
