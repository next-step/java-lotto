package lotto.shop;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.LottoGenerator;
import lotto.NotEnoughMoneyException;
import lotto.Wallet;

public class LottoShopTest {

	LottoShop shop;

	@BeforeEach
	void setUp() {
		shop = new LottoShop();
	}

	@Test
	@DisplayName("자동 로또 발급 성공")
	void buyAutoLottos() {
		Wallet wallet = new Wallet(12345);
		Lottos lottos = shop.buyLottos(wallet);
		assertThat(lottos).isNotNull();
		assertThat(lottos.validate()).isTrue();
		assertThat(lottos.count()).isEqualTo(12);
	}

	@Test
	@DisplayName("수동 로또 발급 성공")
	void buyManualLottos() {
		Wallet wallet = new Wallet(10000);

		Lottos beforeBuy = new Lottos(new ArrayList<>(Arrays.asList(
			LottoGenerator.generate("1,2,3,4,5,6"),
			LottoGenerator.generate("3,4,5,6,7,8")
		)));

		Lottos lottos = shop.buyLottos(wallet, beforeBuy);

		assertThat(lottos).isNotNull();
		assertThat(lottos.validate()).isTrue();
		assertThat(lottos.count()).isEqualTo(10);
		assertThat(lottos.values()).isNotNull();
		assertThat(lottos.values().get(0)).isEqualTo(LottoGenerator.generate("1,2,3,4,5,6"));
		assertThat(lottos.values().get(1)).isEqualTo(LottoGenerator.generate("3,4,5,6,7,8"));
	}

	@Test
	@DisplayName("자동 로또 발급 실패")
	void cannotBuyAutoLottos() {
		Wallet wallet = new Wallet(999);
		assertThatThrownBy(() -> shop.buyLottos(wallet))
			.isInstanceOf(NotEnoughMoneyException.class);
	}

	@Test
	@DisplayName("수동 로또 발급 실패")
	void cannotBuyManualLottos() {
		Wallet wallet = new Wallet(1000);
		Lottos beforeBuy = new Lottos(new ArrayList<>(Arrays.asList(
			LottoGenerator.generate("1,2,3,4,5,6"),
			LottoGenerator.generate("3,4,5,6,7,8")
		)));

		assertThatThrownBy(() -> shop.buyLottos(wallet, beforeBuy))
			.isInstanceOf(NotEnoughMoneyException.class);
	}
}
