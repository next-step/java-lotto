package lotto.domain.strategy;

import lotto.domain.LottoNumbers;
import lotto.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGenerateStrategyTest {

  @DisplayName("새로운 로또 숫자들을 반환한다.")
  @Test
  void test() {
    //given
    NumberGenerateStrategy givenStrategy = new TestNumberGenerateStrategy(TestUtil.getOneToSixLottoNumbers());
    assertThat(givenStrategy.generateNewNumbers()).isEqualTo(new LottoNumbers(TestUtil.getOneToSixLottoNumbers()));
  }
}
