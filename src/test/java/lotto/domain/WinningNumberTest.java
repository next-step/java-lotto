package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

	private WinningNumber winningNumbers;

	@BeforeEach
	void setUp() {
		winningNumbers = new WinningNumber(new LottoNumber(Arrays.asList(3, 6, 8, 11, 19, 28)), 45);
	}

	@Test
	@DisplayName("6개중 0개가 일치하면 등수가 없어야한다.")
	void matchZeroNumberTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(39, 40, 41, 42, 43, 44));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.NOTHING);
	}

	@Test
	@DisplayName("6개중 1개가 일치하면 등수가 없어야한다.")
	void matchOneNumberTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(11, 40, 41, 42, 43, 44));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.NOTHING);
	}

	@Test
	@DisplayName("6개중 2개가 일치하면 등수가 없어야한다.")
	void matchTwoNumberTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(8, 9, 10, 11, 12, 13));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.NOTHING);
	}

	@Test
	@DisplayName("6개중 3개가 일치하면 5등이어야한다.")
	void matchThreeNumberTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(4, 6, 11, 19, 39, 42));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.FIFTH);
	}

	@Test
	@DisplayName("6개중 4개가 일치하면 4등이어야한다.")
	void matchFourNumberTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(6, 8, 11, 19, 39, 42));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.FOURTH);
	}

	@Test
	@DisplayName("6개중 5개가 일치하고 보너스 숫자가 일치하지 않으면 3등이어야한다.")
	void matchFiveNumberTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(3, 6, 11, 19, 28, 42));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.THIRD);
	}

	@Test
	@DisplayName("6개중 6개가 일치하면 1등이어야한다.")
	void matchSixNumberTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(3, 6, 8, 11, 19, 28));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.FIRST);
	}

	@Test
	@DisplayName("보너스 숫자가 1에서 45사이의 숫자가 아니면 IllegalArgumentException이 발생해야한다.")
	void BonusNumberExceptionTest() {
		assertThatThrownBy(() -> new WinningNumber(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)), 60))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("6개중 0개가 일치하고 보너스 숫자가 일치해도 등수가 없어야한다.")
	void matchZeroNumberAndBonusTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(39, 40, 41, 42, 43, 45));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.NOTHING);
	}

	@Test
	@DisplayName("6개중 1개가 일치하고 보너스 숫자가 일치해도 등수가 없어야한다.")
	void matchOneNumberAndBonusTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(11, 40, 41, 42, 43, 45));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.NOTHING);
	}

	@Test
	@DisplayName("6개중 2개가 일치하고 보너스 숫자가 일치해도 등수가 없어야한다.")
	void matchTwoNumberAndBonusTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(8, 9, 10, 11, 12, 45));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.NOTHING);
	}

	@Test
	@DisplayName("6개중 3개가 일치하고 보너스 숫자가 일치해도 5등이어야한다.")
	void matchThreeNumberAndBonusTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(4, 6, 11, 19, 39, 45));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.FIFTH);
	}

	@Test
	@DisplayName("6개중 4개가 일치하고 보너스 숫자가 일치해도 4등이어야한다.")
	void matchFourNumberAndBonusTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(6, 8, 11, 19, 39, 45));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.FOURTH);
	}

	@Test
	@DisplayName("6개중 5개가 일치하고 보너스 숫자가 일치하면 2등이어야한다.")
	void matchFiveNumberAndBonusTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(3, 6, 11, 19, 28, 45));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.SECOND);
	}
}
