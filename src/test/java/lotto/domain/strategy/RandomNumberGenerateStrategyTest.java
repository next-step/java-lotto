package lotto.domain.strategy;

import lotto.domain.LottoNumbers;
import lotto.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGenerateStrategyTest {

  @DisplayName("새로운 로또 숫자들을 반환한다.")
  @Test
  void test() {
    //given
    RandomNumberGenerateStrategy givenStrategy = new TestRandomNumberGenerateStrategy(TestUtil.getOneToSixLottoNumbers());
    assertThat(givenStrategy.generateNewNumbers()).isEqualTo(new LottoNumbers(TestUtil.getOneToSixLottoNumbers()));
  }
}
