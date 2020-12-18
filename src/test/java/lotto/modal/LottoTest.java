package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

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
