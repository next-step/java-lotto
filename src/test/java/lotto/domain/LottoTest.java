package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@DisplayName("당첨넘버와 선택한 로또 넘버 간 일치하는 넘버가 몇개인지 계산한다.")
	@Test
	void test1() {
		Lotto lotto = new Lotto(Arrays.asList(
			LottoNumber.of(1), LottoNumber.of(3), LottoNumber.of(5),
			LottoNumber.of(14), LottoNumber.of(22), LottoNumber.of(45)
		));
		assertThat(lotto.calculateScore(new WinningNumbers("1, 2, 3, 4, 5, 6"), LottoNumber.of(7))).isEqualTo(new Score(3, 0));
	}

	@DisplayName("로또 넘버에 보너스 넘버가 있는 경우.")
	@Test
	void test2() {
		Lotto lotto = new Lotto(Arrays.asList(
			LottoNumber.of(1), LottoNumber.of(3), LottoNumber.of(5),
			LottoNumber.of(14), LottoNumber.of(22), LottoNumber.of(45)
		));
		Score score = lotto.calculateScore(new WinningNumbers("1, 3, 5, 22, 45, 40"), LottoNumber.of(14));
		assertThat(score).isEqualTo(new Score(5, 1));
	}

	@DisplayName("로또 넘버에 보너스 넘버가 없는 경우.")
	@Test
	void test3() {
		Lotto lotto = new Lotto(Arrays.asList(
			LottoNumber.of(1), LottoNumber.of(3), LottoNumber.of(5),
			LottoNumber.of(14), LottoNumber.of(22), LottoNumber.of(45)
		));
		Score score = lotto.calculateScore(new WinningNumbers("1, 3, 5, 22, 45, 40"), LottoNumber.of(23));
		assertThat(score).isEqualTo(new Score(5, 0));
	}
}
