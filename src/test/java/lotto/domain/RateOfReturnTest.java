package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateOfReturnTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    long inputMoney = 5000;
    long returnMoney = 1000;

    //when
    RateOfReturn rateOfReturn = new RateOfReturn(returnMoney, inputMoney);

    //then
    assertThat(rateOfReturn.rate()).isEqualTo((double) returnMoney / inputMoney);
  }

  @Test
  @DisplayName("잘못된 생성 테스트(초기자본 0일떄)")
  void invalidCreateTest() {
    //given
    long inputMoney = 0;
    long returnMoney = 1000;

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new RateOfReturn(returnMoney, inputMoney);
    });
  }
}
