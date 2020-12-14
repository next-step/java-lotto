package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

	private WinningNumber winningNumbers;

	@BeforeEach
	void setUp() {
		winningNumbers = new WinningNumber(Arrays.asList(3, 6, 8, 11, 19, 28), 45);
	}

	@Test
	void matchThreeNumberTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(4, 6, 11, 19, 39, 42));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.FOURTH);
	}

	@Test
	void matchFourNumberTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(6, 8, 11, 19, 39, 42));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.THIRD);
	}

	@Test
	void matchFiveNumberTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(3, 6, 11, 19, 28, 42));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.SECOND);
	}

	@Test
	void matchSixNumberTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(3, 6, 8, 11, 19, 28));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.FIRST);
	}

	@Test
	void BonusNumberExceptionTest() {
		assertThatThrownBy(() -> new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 60))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void matchFiveNumberAndBonusTest() {
		LottoNumber lottoNumber = new LottoNumber(Arrays.asList(3, 6, 11, 19, 28, 45));
		assertThat(winningNumbers.match(lottoNumber)).isEqualTo(LottoRank.SECOND);
	}
}
