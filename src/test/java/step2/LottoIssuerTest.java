package step2;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step2.domain.Lotto;
import step2.domain.LottoMachine;
import step2.domain.LottoNumber;
import step2.domain.LottoNumbers;
import step2.domain.LottoPrice;
import step2.domain.LottoPurchase;
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
		Lottos lottos = LottoMachine.issue(new LottoPurchase(new LottoPrice(1900)));
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
		Lottos lottos = LottoMachine.issue(new LottoPurchase(new LottoPrice(source)));
		assertThat(lottos.size()).isEqualTo(expected);
	}

	@DisplayName("보너스 볼 매치")
	@Test
	void given_lotto_when_matches_bonus_number_then_return_true() {
		final LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
		final LottoNumber bonusNumber = new LottoNumber(6);
		Lotto lotto = new Lotto(lottoNumbers);

		assertThat(lotto.matchesBonusNumber(bonusNumber)).isTrue();
	}

	@DisplayName("수동으로 구매할 로또가 있을 경우 그 수만큼 구입금액에 따른 자동 로또 생성 수에서 차감")
	@Test
	void given_manual_counts_when_purchase_getAutoIssueCount_then_return_auto_issue_count_diff_with_manual_count() {
		final LottoPrice lottoPrice = new LottoPrice(14000);
		final List<LottoNumbers> manualLottoNumbers = Arrays.asList(
			new LottoNumbers(8, 21, 23, 41, 42, 43),
			new LottoNumbers(3, 5, 11, 16, 32, 38),
			new LottoNumbers(7, 11, 16, 35, 36, 44));

		LottoPurchase lottoPurchase = new LottoPurchase(lottoPrice, manualLottoNumbers);

		assertThat(lottoPurchase.getAutoLottoIssueCount()).isEqualTo(11);
	}

	@DisplayName("수동 로또 수를 입력해서 로또 머신에게 발급 요청시 원하는 갯수 발급")
	@Test
	void given_manual_counts_when_lotto_machen_issue_then_lottos() {
		final LottoPrice lottoPrice = new LottoPrice(14000);
		final List<LottoNumbers> manualLottoNumbers = Arrays.asList(
			new LottoNumbers(8, 21, 23, 41, 42, 43),
			new LottoNumbers(3, 5, 11, 16, 32, 38),
			new LottoNumbers(7, 11, 16, 35, 36, 44));

		LottoPurchase lottoPurchase = new LottoPurchase(lottoPrice, manualLottoNumbers);
		Lottos lottos = LottoMachine.issue(lottoPurchase);

		assertThat(lottos.getLottos().size()).isEqualTo(14);
	}

}
