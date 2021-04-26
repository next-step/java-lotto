package study.step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.domain.LottoPrice;

public class LottoPriceTest {

  @DisplayName("구매 금액을 입력했을 때, 로또 갯수를 구하는 테스트")
  @Test
  void lottoCountSuccess() {
    // given
    int money = 4000;

    // when
    LottoPrice lottoPrice = new LottoPrice(money);

    // then
    assertThat(lottoPrice).isEqualTo(new LottoPrice(money));
  }

  @DisplayName("구매 금액을 0원을 입력했을 때, 로또 갯수를 구하는 테스트")
  @Test
  void lottoCountFail() {
    // given
    int money = 0;

    // when
    LottoPrice lottoPrice = new LottoPrice(money);

    // then
    assertThat(lottoPrice).isEqualTo(new LottoPrice(money));
  }

}
