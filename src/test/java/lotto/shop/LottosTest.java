package lotto.shop;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.EmptyLottoListException;
import lotto.LottoGenerator;
import lotto.Wallet;

public class LottosTest {

	LottoShop shop;

	@BeforeEach
	void setUp() {
		shop = new LottoShop();
	}

	@Test
	@DisplayName("구입한 로또 갯수 확인")
	void lottos_발급_테스트() {
		Lottos lottos1 = shop.buyLottos(new Wallet(10999));
		assertThat(lottos1.count()).isEqualTo(10);
		Lottos lottos2 = shop.buyLottos(new Wallet(254846));
		assertThat(lottos2.count()).isEqualTo(254);
	}

	@Test
	@DisplayName("돈이 부족할 경우 예외 발생")
	void lottos_발급_실패_테스트() {
		assertThatThrownBy(() -> shop.buyLottos(new Wallet(999)))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("로또스의 밸류값이 불변인지 확인")
	void lottos_밸류값_불변_테스트() {
		Lottos lottos = shop.buyLottos(new Wallet(5000));
		assertThatThrownBy(() -> lottos.values().add(LottoGenerator.generate()))
			.isInstanceOf(UnsupportedOperationException.class);
		assertThatThrownBy(() -> lottos.values().remove(0))
			.isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@DisplayName("0개의 로또 입력 불가처리")
	void doesNotAllowEmptyList() {
		assertThatThrownBy(() -> new Lottos(Collections.emptyList()))
			.isInstanceOf(EmptyLottoListException.class);
	}

	@Test
	@DisplayName("샵에서 인증받은 로또인지 확인")
	void certifiedLottosCheck() {
		Lottos certified = shop.buyLottos(new Wallet(10999));
		Lottos uncertified = new Lottos(new ArrayList<>(Arrays.asList(
			LottoGenerator.generate("1,2,3,4,5,6"),
			LottoGenerator.generate("3,4,5,6,7,8")
		)));

		assertThat(certified.validate()).isTrue();
		assertThat(uncertified.validate()).isFalse();
	}
}
