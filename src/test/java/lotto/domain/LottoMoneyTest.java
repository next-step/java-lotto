package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyTest {

  @DisplayName("금액을 주입받으면 객체가 정상생성되는지 테스트.")
  @Test
  void 금액주입시객체생성() {
    LottoMoney lottoMoney = new LottoMoney(1000);

    assertThat(lottoMoney.getMoney()).isEqualTo(1000);
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
}