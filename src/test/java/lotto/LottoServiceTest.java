package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoReport;
import lotto.domain.UserLotto;

class LottoServiceTest {

	@DisplayName("로또 구매 테스트")
	@Test
	void buyLotto() {
		// given
		LottoService lottoService = new LottoService();

		// when
		UserLotto userLotto = lottoService.buyLotto("1000");

		// then
		assertThat(userLotto).isNotNull();
	}

	@DisplayName("로또 당첨 리포트 테스트")
	@Test
	void report() {
		// given
		LottoService lottoService = new LottoService();
		UserLotto userLotto = lottoService.buyLotto("1000");

		// when
		LottoReport report = lottoService.report("1,2,3,4,5,6", userLotto);

		// then
		assertThat(report).isNotNull();
	}

}
