package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.LottoNumbers;
import step2.domain.LottoResults;
import step2.domain.LottoWin;
import step2.domain.Lottos;

public class LottoResultTest {

	@Order(1)
	@DisplayName("로또 결과 생성 - 3개 일치")
	@Test
	void given_lotto_when_lottos_result_then_return_result_3_match() {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final Integer[] winNumbers = { 1, 2, 3, 9, 10, 11 };
		final LottoNumber bonusNumber = new LottoNumber(12);
		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(lotto);
		LottoResults lottoResults = lottos.result(new LottoNumbers(winNumbers), bonusNumber);

		assertThat(lottoResults.getLottoResults()).containsKey(LottoWin.MATCH_3);
		assertThat(lottoResults.getLottoResults()).hasSize(1);
	}

	@Order(2)
	@DisplayName("로또 결과 생성 - 4개 일치")
	@Test
	void given_lotto_when_lottos_result_then_return_result_4_match() {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final Integer[] winNumbers = { 1, 2, 3, 4, 10, 11 };
		final LottoNumber bonusNumber = new LottoNumber(12);
		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(lotto);
		LottoResults lottoResults = lottos.result(new LottoNumbers(winNumbers), bonusNumber);

		assertThat(lottoResults.getLottoResults()).containsKey(LottoWin.MATCH_4);
		assertThat(lottoResults.getLottoResults()).hasSize(1);
	}

	@Order(3)
	@DisplayName("로또 결과 생성 - 5개 일치")
	@Test
	void given_lotto_when_lottos_result_then_return_result_5_match() {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final Integer[] winNumbers = { 1, 2, 3, 4, 5, 11 };
		final LottoNumber bonusNumber = new LottoNumber(12);
		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(lotto);
		LottoResults lottoResults = lottos.result(new LottoNumbers(winNumbers), bonusNumber);

		assertThat(lottoResults.getLottoResults()).containsKey(LottoWin.MATCH_5);
		assertThat(lottoResults.getLottoResults()).hasSize(1);
	}

	@Order(4)
	@DisplayName("로또 결과 생성 - 5개 보너스 일치")
	@Test
	void given_lotto_when_lottos_result_then_return_result_5_bonus_match() {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final Integer[] winNumbers = { 1, 2, 3, 4, 5, 11 };
		final LottoNumber bonusNumber = new LottoNumber(6);
		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(lotto);
		LottoResults lottoResults = lottos.result(new LottoNumbers(winNumbers), bonusNumber);

		assertThat(lottoResults.getLottoResults()).containsKey(LottoWin.MATCH_5_BONUS);
		assertThat(lottoResults.getLottoResults()).hasSize(1);
	}

	@Order(5)
	@DisplayName("로또 결과 생성 - 6개 일치")
	@Test
	void given_lotto_when_lottos_result_then_return_result_6_match() {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final Integer[] winNumbers = { 1, 2, 3, 4, 5, 6 };
		final LottoNumber bonusNumber = new LottoNumber(12);
		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(lotto);
		LottoResults lottoResults = lottos.result(new LottoNumbers(winNumbers), bonusNumber);

		assertThat(lottoResults.getLottoResults()).containsKey(LottoWin.MATCH_6);
		assertThat(lottoResults.getLottoResults()).hasSize(1);
	}

	@Order(6)
	@DisplayName("상금 계산 - 3개 일치")
	@Test
	void given_lotto_results_when_get_win_price_then_return_price_3() {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final Integer[] winNumbers = { 1, 2, 3, 13, 14, 15 };
		final LottoNumber bonusNumber = new LottoNumber(9);
		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(lotto);

		LottoResults lottoResults = lottos.result(new LottoNumbers(winNumbers), bonusNumber);

		assertThat(lottoResults.getWinPrice()).isEqualTo(5000);
	}

	@Order(7)
	@DisplayName("상금 계산 - 4개 일치")
	@Test
	void given_lotto_results_when_get_win_price_then_return_price_4() {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final Integer[] winNumbers = { 1, 2, 3, 9, 10, 11 };
		final LottoNumber bonusNumber = new LottoNumber(12);
		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(lotto);

		LottoResults lottoResults = lottos.result(new LottoNumbers(winNumbers), bonusNumber);

		assertThat(lottoResults.getWinPrice()).isEqualTo(LottoWin.MATCH_3.getPrice());
	}

	@Order(8)
	@DisplayName("상금 계산 - 5개 일치")
	@Test
	void given_lotto_results_when_get_win_price_then_return_price_5() {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final Integer[] winNumbers = { 1, 2, 3, 4, 5, 11 };
		final LottoNumber bonusNumber = new LottoNumber(12);
		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(lotto);

		LottoResults lottoResults = lottos.result(new LottoNumbers(winNumbers), bonusNumber);

		assertThat(lottoResults.getWinPrice()).isEqualTo(LottoWin.MATCH_5.getPrice());
	}

	@Order(9)
	@DisplayName("상금 계산 - 5개 보너스 일치")
	@Test
	void given_lotto_results_when_get_win_price_then_return_price_5_bonus() {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final Integer[] winNumbers = { 1, 2, 3, 4, 5, 11 };
		final LottoNumber bonusNumber = new LottoNumber(6);
		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(lotto);

		LottoResults lottoResults = lottos.result(new LottoNumbers(winNumbers), bonusNumber);

		assertThat(lottoResults.getWinPrice()).isEqualTo(LottoWin.MATCH_5_BONUS.getPrice());
	}

	@Order(10)
	@DisplayName("상금 계산 - 6개 일치")
	@Test
	void given_lotto_results_when_get_win_price_then_return_price() {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final Integer[] winNumbers = { 1, 2, 3, 4, 5, 6 };
		final LottoNumber bonusNumber = new LottoNumber(12);
		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(lotto);

		LottoResults lottoResults = lottos.result(new LottoNumbers(winNumbers), bonusNumber);

		assertThat(lottoResults.getWinPrice()).isEqualTo(LottoWin.MATCH_6.getPrice());
	}

}
