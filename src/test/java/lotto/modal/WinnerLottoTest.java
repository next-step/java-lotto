package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerLottoTest {

	WinnerLotto winnerLotto;

	@BeforeEach
	void init() {
		List<String> inputStr = Arrays.asList("1", "2", "3", "4", "5", "6");

		List<LottoNumber> lottoList = Lotto.generateManualLotto(inputStr);

		winnerLotto = new WinnerLotto(new Lotto(lottoList), new LottoNumber(7));
	}

	@Test
	@DisplayName("당첨 로또 객체: 당첨번호 6개 일치 테스트")
	void compare1ThLottoTest() {

		List<LottoNumber> userGetLotto = Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "6"));

		Lotto userLott = new Lotto(userGetLotto);

		assertThat(winnerLotto.getMatchCount(userLott)).isEqualTo(6);
	}

	@Test
	@DisplayName("당첨 로또 객체: 당첨번호 5개 일치 + 보너스 테스트")
	void compare2ThLottoTest() {

		List<LottoNumber> userGetLotto = Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "7"));
		Lotto userLott = new Lotto(userGetLotto);

		assertThat(winnerLotto.getMatchCount(userLott)).isEqualTo(5);
	}

	@Test
	@DisplayName("당첨 로또 객체: 당첨번호 5개 일치 테스트")
	void compare3ThLottoTest() {

		List<LottoNumber> userGetLotto = Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "45"));
		Lotto userLott = new Lotto(userGetLotto);

		assertThat(winnerLotto.getMatchCount(userLott)).isEqualTo(5);
	}

	@Test
	@DisplayName("당첨 로또 객체: 당첨번호 4개 일치 테스트")
	void compare4ThLottoTest() {

		List<LottoNumber> userGetLotto = Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "5", "37", "45"));
		Lotto userLott = new Lotto(userGetLotto);

		assertThat(winnerLotto.getMatchCount(userLott)).isEqualTo(4);
	}

	@Test
	@DisplayName("당첨 로또 객체: 당첨번호 3개 일치 테스트")
	void compare5ThLottoTest() {

		List<LottoNumber> userGetLotto = Lotto.generateManualLotto(Arrays.asList("1", "2", "5", "34", "37", "45"));
		Lotto userLott = new Lotto(userGetLotto);

		assertThat(winnerLotto.getMatchCount(userLott)).isEqualTo(3);
	}

	@Test
	@DisplayName("당첨 로또 객체: 유효성 검사 테스트")
	void validationTest() {

		// 1. 당첨 Lotto 객체가 null 이 아니여야 한다.
		// 2. 당첨 보너스 번호가 null 이 아니여야 한다.
		// 3. 당첨 Lotto 객체와 보너스 번호가 동일한 숫자를 가지면 안된다.
		assertThatIllegalArgumentException().isThrownBy(() -> new WinnerLotto(null, null));
		assertThatIllegalArgumentException().isThrownBy(() -> new WinnerLotto(new Lotto(), null));
		assertThatIllegalArgumentException().isThrownBy(() -> new WinnerLotto(null, new LottoNumber(2)));
		assertThatIllegalArgumentException().isThrownBy(
			() -> new WinnerLotto(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "6"))),
				new LottoNumber(2)));
	}

	@Test
	@DisplayName("당첨 로또 객체: 객체 생성 테스트")
	void initTest() {
		WinnerLotto winnerLotto = new WinnerLotto(
			new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "6"))), new LottoNumber(7));
		assertThat(winnerLotto).isNotNull();
	}
}
