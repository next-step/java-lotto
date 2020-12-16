package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	Lotto compareLotto;

	@BeforeEach
	void init() {
		List<String> inputStr = Arrays.asList("1", "2", "3", "4", "5", "6");

		List<LottoNumber> lottoList = Lotto.generateManualLotto(inputStr);

		compareLotto = new Lotto(lottoList);
	}

	@Test
	@DisplayName("로또: 당첨번호 6개 일치 테스트")
	void compare1ThLottoTest() {

		List<LottoNumber> userGetLotto = Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "6"));

		Lotto userLott = new Lotto(userGetLotto);

		assertThat(userLott).isEqualTo(compareLotto);
		assertThat(userLott.getMatchCount(compareLotto)).isEqualTo(6);
	}

	@Test
	@DisplayName("로또: 당첨번호 5개 일치 테스트")
	void compare2ThLottoTest() {

		List<LottoNumber> userGetLotto = Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "45"));
		Lotto userLott = new Lotto(userGetLotto);

		assertThat(userLott.getMatchCount(compareLotto)).isEqualTo(5);
	}

	@Test
	@DisplayName("로또: 당첨번호 4개 일치 테스트")
	void compare3ThLottoTest() {

		List<LottoNumber> userGetLotto = Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "5", "37", "45"));
		Lotto userLott = new Lotto(userGetLotto);

		assertThat(userLott.getMatchCount(compareLotto)).isEqualTo(4);
	}

	@Test
	@DisplayName("로또: 당첨번호 3개 일치 테스트")
	void compare4ThLottoTest() {

		List<LottoNumber> userGetLotto = Lotto.generateManualLotto(Arrays.asList("1", "2", "5", "34", "37", "45"));
		Lotto userLott = new Lotto(userGetLotto);

		assertThat(userLott.getMatchCount(compareLotto)).isEqualTo(3);
	}

	@Test
	@DisplayName("로또: 메뉴얼 로또 객체 생성 테스트")
	void initManualLottoTest() {

		List<LottoNumber> userInputList = Lotto.generateManualLotto(Arrays.asList("1", "3", "23", "34", "37", "45"));

		Lotto lotto = new Lotto(userInputList);

		assertThat(lotto).isEqualTo(new Lotto(userInputList));
	}

	@Test
	@DisplayName("로또: 랜덤 로또 객체 생성 테스트")
	void initRandomLottoTest() {
		Lotto lotto = new Lotto();
		lotto.getLotto()
			.forEach(System.out::println);

		assertThat(lotto).isNotNull();
	}
}
