package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerLottoTest {

	private Lotto lotto;
	private LottoNumber bonusNumber;
	private WinnerLotto winnerLotto;

	@BeforeEach
	void init() {
		lotto = Lotto.generateManualLotto("1,2,3,4,5,6");
		bonusNumber = LottoNumber.generateNumber(7);
		winnerLotto = WinnerLotto.generateWinner(lotto, bonusNumber);
	}

	@Test
	@DisplayName("당첨 로또 객체: 당첨번호 6개 일치 테스트")
	void compare1ThLottoTest() {
		Lotto userLott = Lotto.generateManualLotto("1,2,3,4,5,6");
		assertThat(winnerLotto.getMatchCount(userLott)).isEqualTo(6);
	}

	@Test
	@DisplayName("당첨 로또 객체: 당첨번호 5개 일치 + 보너스 테스트")
	void compare2ThLottoTest() {
		Lotto userLott = Lotto.generateManualLotto("1,2,3,4,5,7");
		assertThat(winnerLotto.getMatchCount(userLott)).isEqualTo(5);
	}

	@Test
	@DisplayName("당첨 로또 객체: 당첨번호 5개 일치 테스트")
	void compare3ThLottoTest() {
		Lotto userLott = Lotto.generateManualLotto("1,2,3,4,5,45");
		assertThat(winnerLotto.getMatchCount(userLott)).isEqualTo(5);
	}

	@Test
	@DisplayName("당첨 로또 객체: 당첨번호 4개 일치 테스트")
	void compare4ThLottoTest() {
		Lotto userLott = Lotto.generateManualLotto("1,2,3,5,37,45");
		assertThat(winnerLotto.getMatchCount(userLott)).isEqualTo(4);
	}

	@Test
	@DisplayName("당첨 로또 객체: 당첨번호 3개 일치 테스트")
	void compare5ThLottoTest() {
		Lotto userLott = Lotto.generateManualLotto("1,2,3,34,37,45");
		assertThat(winnerLotto.getMatchCount(userLott)).isEqualTo(3);
	}

	@Test
	@DisplayName("당첨 로또 객체: 유효성 검사 테스트")
	void validationTest() {
		// 1. 당첨 Lotto 객체가 null 이 아니여야 한다.
		// 2. 당첨 보너스 번호가 null 이 아니여야 한다.
		// 3. 당첨 Lotto 객체와 보너스 번호가 동일한 숫자를 가지면 안된다.
		assertThatIllegalArgumentException().isThrownBy(() -> WinnerLotto.generateWinner(null, null));
		assertThatIllegalArgumentException().isThrownBy(
			() -> WinnerLotto.generateWinner(Lotto.generateRandomLotto(), null));
		assertThatIllegalArgumentException().isThrownBy(
			() -> WinnerLotto.generateWinner(null, LottoNumber.generateNumber(2)));
		assertThatIllegalArgumentException().isThrownBy(
			() -> WinnerLotto.generateWinner(Lotto.generateManualLotto("1,2,3,4,5,6"), LottoNumber.generateNumber(2)));
	}

	@Test
	@DisplayName("당첨 로또 객체: 객체 생성 테스트")
	void initTest() {
		WinnerLotto winnerLottoTest = WinnerLotto.generateWinner(lotto, bonusNumber);
		assertThat(winnerLottoTest).isNotNull();
	}
}
