package lotto.view;

import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.LottoNumber;
import lotto.LottoShop;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoShopTest {

  public static class TestLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
      return new Lotto(List.of(
              new LottoNumber(1),
              new LottoNumber(45),
              new LottoNumber(2),
              new LottoNumber(44),
              new LottoNumber(3),
              new LottoNumber(43)
      ));
    }
  }

  @DisplayName("금액을 지불하면 가격에 맞는 로또 티켓들을 생성해주는 기능을 테스트한다.")
  @Test
  void testBuyLottoTicket() {
    int money = 1000;

    LottoShop lottoShop = new LottoShop(new TestLottoGenerator());
    List<Lotto> lottos = lottoShop.buyLottos(money);

    assertEquals(1, lottos.size());
  }

  @DisplayName("0 미만의 금액을 지불할 경우 로또 티켓을 구매할 수 없다.")
  @Test
  void testBuyLottoTicketWithNegativeMoney() {
    int money = -1000;

    LottoShop lottoShop = new LottoShop(new TestLottoGenerator());

    assertThatThrownBy(() -> lottoShop.buyLottos(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0 미만의 금액으로 로또를 구매할 수 없습니다.");
  }

  @DisplayName("로또 한 장의 가격보다 적은 금액을 지불할 경우 로또 티켓을 구매할 수 없다.")
  @Test
  void testBuyLottoTicketWithLessMoney() {
    int money = Lotto.PRICE - 100;

    LottoShop lottoShop = new LottoShop(new TestLottoGenerator());

    assertThatThrownBy(() -> lottoShop.buyLottos(money))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 한 장의 가격보다 적은 금액으로 로또를 구매할 수 없습니다.");
  }
}
