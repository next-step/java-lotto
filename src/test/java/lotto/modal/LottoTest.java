package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

	@Test
	@DisplayName("로또: 메뉴얼 로또 객체 생성 테스트")
	void initManualLottoTest() {

		Lotto lotto = Lotto.generateManualLotto("1,3,23,34,35,36");

		assertThat(lotto).isEqualTo(Lotto.generateManualLotto("1,3,23,34,35,36"));
	}

	@Test
	@DisplayName("로또: 랜덤 로또 객체 생성 테스트")
	void initRandomLottoTest() {
		Lotto lotto = Lotto.generateRandomLotto();
		lotto.getLotto()
			.forEach(System.out::println);

		assertThat(lotto).isNotNull();
	}
}
