package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.message.Message;
import lotto.service.Operation;
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
        () -> new LottoMoney(-1)
    )
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(Message.MSG_ERROR_LIMIT_MONEY);
  }

  @DisplayName("입력한 금액이 천원단위 인지 검증 테스트.")
  @Test
  void 로또한장단위금액확인() {
    assertThatThrownBy(
        () -> new LottoMoney(1)
    )
        .isInstanceOf(RuntimeException.class)
        .hasMessage(Message.MSG_ERROR_WRONG_MONEY);
  }

  @DisplayName("구매후 당첨된 금액기준으로 수익률을 계산하는 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"14000,5000", "10000,0"})
  void 당첨금수익률(int money, int winMoney) {
    LottoMoney lottoMoney = new LottoMoney(money);
    double reward = LottoMoney.getReward(winMoney, lottoMoney);
    assertThat(reward).isEqualTo((double) winMoney / (double) money);
  }

  @DisplayName("천원단위 금액입력시 구매가능한 로또장수 반환 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"1000,1", "2000,2"})
  void 금액기준로또구매장수반환(int money, int count) {
    LottoMoney lottoMoney = new LottoMoney(money);
    assertThat(lottoMoney.countLottoToMoney(Operation.DIVISION_SHARE, 1000)).isEqualTo(count);
  }
}