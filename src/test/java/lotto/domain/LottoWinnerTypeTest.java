package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 07/11/2018.
 */
public class LottoWinnerTypeTest {

	@Test
	public void test_6개() {
		LottoWinnerType lottoWinnerType = LottoWinnerType.findByMatchingCountAndBonus(6, false);
		assertThat(lottoWinnerType).isEqualTo(LottoWinnerType.FIRST_WINNER);
	}

	@Test
	public void test_6개_보너스() {
		LottoWinnerType lottoWinnerType = LottoWinnerType.findByMatchingCountAndBonus(6, true);
		assertThat(lottoWinnerType).isEqualTo(LottoWinnerType.FIRST_WINNER);
	}

	@Test
	public void test_5개() {
		LottoWinnerType lottoWinnerType = LottoWinnerType.findByMatchingCountAndBonus(5, false);
		assertThat(lottoWinnerType).isEqualTo(LottoWinnerType.THIRD_WINNER);
	}

	@Test
	public void test_5개_보너스() {
		LottoWinnerType lottoWinnerType = LottoWinnerType.findByMatchingCountAndBonus(5, true);
		assertThat(lottoWinnerType).isEqualTo(LottoWinnerType.SECOND_WINNER);
	}

	@Test
	public void test_4개() {
		LottoWinnerType lottoWinnerType = LottoWinnerType.findByMatchingCountAndBonus(4, false);
		assertThat(lottoWinnerType).isEqualTo(LottoWinnerType.FOURTH_WINNER);
	}

	@Test
	public void test_4개_보너스() {
		LottoWinnerType lottoWinnerType = LottoWinnerType.findByMatchingCountAndBonus(4, true);
		assertThat(lottoWinnerType).isEqualTo(LottoWinnerType.FOURTH_WINNER);
	}

	@Test
	public void test_3개() {
		LottoWinnerType lottoWinnerType = LottoWinnerType.findByMatchingCountAndBonus(3, false);
		assertThat(lottoWinnerType).isEqualTo(LottoWinnerType.FIFTH_WINNER);
	}

	@Test
	public void test_3개_보너스() {
		LottoWinnerType lottoWinnerType = LottoWinnerType.findByMatchingCountAndBonus(3, true);
		assertThat(lottoWinnerType).isEqualTo(LottoWinnerType.FIFTH_WINNER);
	}

	@Test
	public void test_2개() {
		LottoWinnerType lottoWinnerType = LottoWinnerType.findByMatchingCountAndBonus(2, false);
		assertThat(lottoWinnerType).isEqualTo(LottoWinnerType.LOSING_TICKET);
	}

	@Test
	public void test_2개_보너스() {
		LottoWinnerType lottoWinnerType = LottoWinnerType.findByMatchingCountAndBonus(2, true);
		assertThat(lottoWinnerType).isEqualTo(LottoWinnerType.LOSING_TICKET);
	}
}