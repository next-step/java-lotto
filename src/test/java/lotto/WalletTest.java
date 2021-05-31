package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WalletTest {

	@Test
	@DisplayName("money에 음수를 차단하는지 확인")
	void money는_음수인가() {
		assertThrows(OutOfBoundValueException.class, () -> new Wallet(-1));
	}

	@Test
	@DisplayName("금액의 구매한도가 정상적으로 반환되는지 확인")
	void buyLimitCheck() {
		Wallet wallet1 = new Wallet(12345);
		assertThat(wallet1.buyLimit()).isEqualTo(12);
		Wallet wallet2 = new Wallet(456789);
		assertThat(wallet2.buyLimit()).isEqualTo(456);
	}

	@Test
	@DisplayName("금액을 지불한 후 남은 구매한도 확인")
	void buyManualLotto() {
		Wallet wallet = new Wallet(12345);
		Wallet afterWallet = wallet.pay(10000);

		assertThat(afterWallet.buyLimit()).isEqualTo(2);
	}

	@Test
	@DisplayName("한도 이상으로 지불할 경우 예외 발생")
	void buyManualLottoError() {
		Wallet wallet = new Wallet(12345);

		assertThrows(NotEnoughMoneyException.class, () -> wallet.pay(13000));
	}
}
