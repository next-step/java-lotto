package lotto.domain.strategy;

import lotto.domain.LottoNumbers;
import lotto.util.TestUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGenerateStrategyTest {

  @Test
  void test() {
    //given
    RandomNumberGenerateStrategy givenStrategy = new TestRandomNumberGenerateStrategy();
    assertThat(givenStrategy.generateNewNumbers()).isEqualTo(new LottoNumbers(TestUtil.getOneToSixLottoNumbers()));
  }
}
