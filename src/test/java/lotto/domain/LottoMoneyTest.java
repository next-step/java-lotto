package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMoneyTest {

  @DisplayName("금액을 주입받으면 객체가 정상생성되는지 테스트.")
  @Test
  void 금액주입시객체생성() {
    LottoMoney lottoMoney = new LottoMoney(1000);

    assertThat(lottoMoney.equals(new LottoMoney(1000)));
  }

  @DisplayName("0미만의 음수값으로 금액 입력 검증 테스트.")
  @Test
  void 최소금액제한() {
    assertThatThrownBy(
        ()-> new LottoMoney(-1)
    ).isInstanceOf(IllegalArgumentException.class)
        .hasMessage(Message.MSG_ERROR_LIMIT_MONEY);
  }

  @DisplayName("구매후 당첨된 금액기준으로 수익률을 계산하는 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"14000,5000","10000,0"})
  void 당첨금수익률(int money, int winMoney) {
    LottoMoney lottoMoney = new LottoMoney(money);
    double reward = lottoMoney.getReward(winMoney);
    assertThat(reward).isEqualTo((double) winMoney / (double) money);
  }
}