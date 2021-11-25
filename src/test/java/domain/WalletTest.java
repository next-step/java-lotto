package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WalletTest {

  @ParameterizedTest
  @ValueSource(ints = {1_500, 15_000, 150_000})
  @DisplayName("지갑은 로또를 구매할 때 가진 돈 범위 내에서 가능한 많은 로또를 구매함을 검증하는 테스트")
  void walletWillBuyLottosAsManyAsPossible(int input) {
    // given
    int availableLottoCount = input / Lotto.PRICE_PER_LOTTO;
    Wallet wallet = new Wallet(input);

    // when
    wallet.buyLottos();

    // then
    assertThat(wallet.getLottos().getLottoAmount()).isEqualTo(availableLottoCount);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 100})
  @DisplayName("지갑은 로또를 구매할 때 가진 돈이 로또 구매금액 보다 적으면 구매가 불가능함을 검증하는 테스트")
  void walletCannotBuyLottoWhenHaveNotEnoughMoney(int input) {
    // then
    assertThatThrownBy(() -> {
      // given
      Wallet wallet = new Wallet(input);
      // when
      wallet.buyLottos();
    }).isInstanceOf(IllegalArgumentException.class);
  }

}
