package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@DisplayName("숫자를 6개 선택한다. - 중복 없는 케이스")
	@Test
	void test1() {
		Lotto lotto = new Lotto();
		for (Integer number : Arrays.asList(1, 2, 3, 4, 5, 6)) {
			lotto.selectLottoNumbers(number);
		}
		assertThat(lotto.selectedNumbersSize()).isEqualTo(6);
	}

	@DisplayName("숫자를 6개 선택한다. - 중복 있는 케이스")
	@Test
	void test2() {
		Lotto lotto = new Lotto();
		for (Integer number : Arrays.asList(1, 2, 2, 4, 5, 6)) {
			lotto.selectLottoNumbers(number);
		}
		assertThat(lotto.selectedNumbersSize()).isEqualTo(5);
	}

	@DisplayName("당첨넘버와 선택한 로또 넘버 간 일치하는 넘버가 몇개인지 계산한다.")
	@Test
	void test3() {
		Lotto lotto = new Lotto();
		for (Integer number : Arrays.asList(1, 3, 5, 14, 22, 45)) {
			lotto.selectLottoNumbers(number);
		}
		assertThat(lotto.winCount(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(new WinCount(3));
	}
}

