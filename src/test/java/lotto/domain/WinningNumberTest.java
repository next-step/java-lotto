package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {

	private WinningNumber winningNumbers;

	@BeforeEach
	void setUp() {
		winningNumbers = new WinningNumber(Arrays.asList(3, 6, 8, 11, 19, 28));
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
}
