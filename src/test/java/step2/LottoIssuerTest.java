package step2;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step2.domain.Lotto;
import step2.domain.LottoMachine;
import step2.domain.LottoNumber;
import step2.domain.LottoNumbers;
import step2.domain.LottoPrice;
import step2.domain.LottoResult;
import step2.domain.LottoResults;
import step2.domain.LottoWin;
import step2.domain.Lottos;

public class LottoIssuerTest {

	@DisplayName("로또 구입금액 단위 미만의 금액 입력시 익셉션 발생")
	@Test
	void given_lotto_paid_when_lower_than_unit_price_then_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			LottoPrice lottoPrice = new LottoPrice(999);
		});
	}

	@DisplayName("로또 구입금액과 단위금액에 따라 발급 갯수 생성")
	@ParameterizedTest
	@CsvSource(value = {"1900=1", "2900=2", "1000=1", "3000=3", "4500=4"}, delimiter = '=')
	void given_lotto_paid_when_getNumberOfPurchasesPerUnitPrice_then_purchasable_number(final int source,
		final int expected) {
		LottoPrice one = new LottoPrice(source);
		assertThat(one.getNumberOfPurchasesPerUnitPrice()).isEqualTo(expected);
	}

	@DisplayName("로또 구입금액 단위 이상의 금액 입력시 금액에 따른 갯수의 로또 발급")
	@Test
	void given_lotto_paid_when_grater_or_equals_than_unit_price_then_issue_lottos() {
		LottoPrice lottoPrice = new LottoPrice(1900);
		Lottos lottos = LottoMachine.issue(lottoPrice);
		assertThat(lottos.size()).isEqualTo(1);
	}

	@DisplayName("로또 1장 발급")
	@Test
	void given_lotto_when_size_then_return_six() {
		Lotto lotto = new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6));
		assertThat(lotto.getNumbers().size()).isEqualTo(6);
	}

	@DisplayName("로또 여러 장 발급")
	@ParameterizedTest
	@CsvSource(value = {"1900=1", "2900=2", "1000=1", "3000=3", "4500=4"}, delimiter = '=')
	void given_lotto_when_size_then_return_match_count(final int source, final int expected) {
		Lottos lottos = LottoMachine.issue(new LottoPrice(source));
		assertThat(lottos.size()).isEqualTo(expected);
	}

	@DisplayName("로또 번호와 당첨 번호에 따라 당첨 갯수 확인")
	@ParameterizedTest
	@CsvSource(value = {
		"1,2,3,4,5,6=6",
		"1,2,3,4,5,9=5",
		"1,2,3,4,10,11=4",
		"1,2,3,9,10,11=3",
	}, delimiter = '=')
	void given_lotto_when_confirmWinning_return_win_result(final String winNumbersStr, final int matchCount) {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final LottoNumbers winNumbers = new LottoNumbers(Arrays.stream(winNumbersStr.split(","))
			.mapToInt(Integer::parseInt)
			.boxed()
			.toArray(Integer[]::new));

		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));

		lotto.confirmWinning(winNumbers);

		assertThat(lotto.getMatchCount()).isEqualTo(matchCount);
	}

	@DisplayName("로또 결과 생성")
	@Test
	void given_lotto_results_when_has_same_lotto_win_then_return_true() {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final Integer[] winNumbers = { 10, 11, 12, 13, 14, 15 };
		final LottoNumber bonusNumber = new LottoNumber(9);
		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(lotto);
		LottoResults lottoResults = lottos.result(new LottoNumbers(winNumbers), bonusNumber);

		LottoResult lottoResult = new LottoResult(LottoWin.MATCH_0);
		assertThat(lottoResults.has(lottoResult)).isTrue();
	}

	@DisplayName("수익률 계산")
	@Test
	void given_lotto_results_when_get_win_price_then_return_price() {
		final Integer[] lottoNumbers = { 1, 2, 3, 4, 5, 6 };
		final Integer[] winNumbers = { 1, 2, 3, 13, 14, 15 };
		final LottoNumber bonusNumber = new LottoNumber(9);
		Lotto lotto = new Lotto(new LottoNumbers(lottoNumbers));
		Lottos lottos = new Lottos(lotto);

		LottoResults lottoResults = lottos.result(new LottoNumbers(winNumbers), bonusNumber);

		assertThat(lottoResults.getWinPrice()).isEqualTo(5000);
	}

	@DisplayName("보너스 볼 매치")
	@Test
	void given_lotto_when_matches_bonus_number_then_return_true() {
		final LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
		final LottoNumber bonusNumber = new LottoNumber(6);
		Lotto lotto = new Lotto(lottoNumbers);

		assertThat(lotto.matchesBonusNumber(bonusNumber)).isTrue();
	}

}
