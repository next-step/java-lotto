package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

	private Lottos lottos;
	private WinnerLotto winnerLotto;

	@BeforeEach
	void init() {
		lottos = Lottos.generateLottos();
		lottos.addManualLottos("1,10,20,30,40,45");

		winnerLotto = WinnerLotto.generateWinner(
			Lotto.generateManualLotto("1,2,3,4,5,6"),
			LottoNumber.generateNumber("7"));
	}

	@Test
	@DisplayName("로또 결과: 1등 4번, Overflow 테스트")
	void resultOverYieldSuccessLottoTest() {
		lottos.addManualLottos("1,2,3,4,5,45");
		lottos.addManualLottos("1,2,3,4,5,6");
		lottos.addManualLottos("1,2,3,4,5,6");
		lottos.addManualLottos("1,2,3,4,5,6");
		lottos.addManualLottos("1,2,3,4,5,6");

		LottoResult result = LottoResult.generateResult(lottos, winnerLotto);

		assertThat(result.reportYield(Money.generateMoney(6000))).isGreaterThan(new BigDecimal(1));
		assertThat(result.reportRank()).isNotNull();
	}

	@Test
	@DisplayName("로또 결과: 수익률 1 이상(이익) 테스트")
	void resultYieldSuccessLottoTest() {
		lottos.addManualLottos("1,2,3,4,5,45");

		LottoResult result = LottoResult.generateResult(lottos, winnerLotto);

		assertThat(result.reportYield(Money.generateMoney(2000))).isGreaterThan(new BigDecimal(1));
		assertThat(result.reportRank()).isNotNull();
	}

	@Test
	@DisplayName("로또 결과: 수익률 1 이하(손해) 테스트")
	void resultYieldFailLottoTest() {
		lottos.addManualLottos("1,10,17,30,40,41");
		lottos.addManualLottos("1,10,18,31,40,42");
		lottos.addManualLottos("1,10,19,32,40,43");
		lottos.addManualLottos("1,10,20,33,40,44");
		lottos.addManualLottos("1,10,21,34,40,45");

		LottoResult result = LottoResult.generateResult(lottos, winnerLotto);

		assertThat(result.reportYield(Money.generateMoney(6000))).isLessThan(new BigDecimal(1));
		assertThat(result.reportRank()).isNotNull();
	}

	@Test
	@DisplayName("로또 결과: 수익률 0 테스트")
	void resultYieldZeroLottoTest() {

		LottoResult result = LottoResult.generateResult(lottos, winnerLotto);
		assertThat(result.reportYield(Money.generateMoney(1000))).isZero();
	}

	@Test
	@DisplayName("로또 결과: 로또 결과 객체 생성 테스트")
	void initLottoResultTest() {
		Lottos lottosTest = Lottos.generateLottos();
		lottosTest.addRandomLotto(10);

		LottoResult result = LottoResult.generateResult(lottos, winnerLotto);
		assertThat(result).isNotNull();
	}
}

