package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WalletTest {

	@Test
	@DisplayName("money에 음수를 차단하는지 확인")
	void money는_음수인가() {
		assertThatThrownBy(() -> new Wallet(-1))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("money가 로또를 구입하기 충분한지 확인")
	void money가_충분한가() {
		Assertions.assertThrows(NotEnoughMoneyException.class, () -> new Wallet(999));
		Assertions.assertDoesNotThrow(() -> new Wallet(1000));
	}
}
