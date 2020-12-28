package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

	@Test
	@DisplayName("로또: 비교 테스트")
	void compareLottoTest() {
		Lotto lotto1 = Lotto.generateManualLotto("1,3,23,34,35,36");
		Lotto lotto2 = Lotto.generateManualLotto("1,3,23,34,35,36");

		if (lotto1.getLotto().contains(LottoNumber.generateNumber(1))) {
			System.out.println("why?");
		}
		System.out.println(lotto1.compareLottoCount(lotto2));
	}

	@Test
	@DisplayName("로또: 메뉴얼 로또 객체 생성 테스트")
	void initManualLottoTest() {
		Lotto lotto = Lotto.generateManualLotto("1,3,23,34,35,36");

		assertThat(lotto).isEqualTo(Lotto.generateManualLotto("1,3,23,34,35,36"));
	}

	@Test
	@DisplayName("로또: 메뉴얼 로또 객체 실패 생성 테스트")
	void initManualFailLottoTest() {
		/*
		 * 로또 Exception 상황
		 * 1. 로또 숫자가 6개가 아닐떄
		 * 2. 로또 숫자 범위가 1 ~ 45 아닐때
		 */
		assertThatIllegalArgumentException().isThrownBy(() -> Lotto.generateManualLotto("1,3,23,34,35"));
		assertThatIllegalArgumentException().isThrownBy(() -> Lotto.generateManualLotto("1,3,23,34,35,49"));
		assertThatIllegalArgumentException().isThrownBy(() -> Lotto.generateManualLotto("1,3,23,34,35,-45"));
	}

	@Test
	@DisplayName("로또: 랜덤 로또 객체 생성 테스트")
	void initRandomLottoTest() {
		Lotto lotto = Lotto.generateRandomLotto();

		assertThat(lotto).isNotNull();
	}

}
