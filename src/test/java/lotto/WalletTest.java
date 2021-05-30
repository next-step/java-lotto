package lotto;

import static lotto.Wallet.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WalletTest {

	@Test
	@DisplayName("money에 음수를 차단하는지 확인")
	void money는_음수인가() {
		assertThrows(OutOfBoundValueException.class, () -> new Wallet(-1));
	}

	@Test
	@DisplayName("money가 로또를 구입하기 충분한지 확인")
	void money가_충분한가() {
		assertThrows(NotEnoughMoneyException.class, () -> new Wallet(999));
		assertDoesNotThrow(() -> new Wallet(1000));
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
	@DisplayName("로또를 한도 이상으로 입력 시 예외")
	void buyManualLotto() {
		Wallet wallet = new Wallet(12345);
		Lottos beforeBuy = new Lottos(IntStream.range(0, 13)
			.mapToObj(i -> LottoGenerator.generate())
			.collect(Collectors.toList()));

		assertThrows(NotEnoughMoneyException.class, () -> wallet.buyManual(beforeBuy));
	}

	@Test
	@DisplayName("로또를 구매하고 남은 돈 확인")
	void checkChangeMoney() {
		int money = 12345;
		int buyCount = 3;
		Wallet wallet = new Wallet(money);
		Lottos lottos = new Lottos(IntStream.range(0, buyCount)
			.mapToObj(i -> LottoGenerator.generate())
			.collect(Collectors.toList()));

		wallet.buyManual(lottos);

		assertThat(wallet.money()).isEqualTo(money - buyCount * LOTTO_PRICE);
	}
}
