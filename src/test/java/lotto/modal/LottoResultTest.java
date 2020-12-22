package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

	private List<Lotto> lottoPackage;
	private ManualLotto manualLotto;
	private WinnerLotto winnerLotto;
	private Game lottoGame;

	@BeforeEach
	void init() {
		lottoPackage = new ArrayList<>();
		lottoPackage.add(Lotto.generateLotto("1,10,20,30,40,45"));

		winnerLotto = new WinnerLotto(Lotto.generateLotto("1,2,3,4,5,6"),
			new LottoNumber("7"));
	}

	@Test
	@DisplayName("로또 결과: 1등 4번, Overflow 테스트")
	void resultOverYieldSuccessLottoTest() {
		lottoPackage.add(Lotto.generateLotto("1,2,3,4,5,45"));
		lottoPackage.add(Lotto.generateLotto("1,2,3,4,5,6"));
		lottoPackage.add(Lotto.generateLotto("1,2,3,4,5,6"));
		lottoPackage.add(Lotto.generateLotto("1,2,3,4,5,6"));
		lottoPackage.add(Lotto.generateLotto("1,2,3,4,5,6"));

		manualLotto = new ManualLotto(lottoPackage);
		lottoGame = new Game(manualLotto, 0);

		LottoResult result = lottoGame.getLottoResult(winnerLotto);

		assertThat(result.report(new GameCondition("6000"))).isGreaterThan(new BigDecimal(1));
	}

	@Test
	@DisplayName("로또 결과: 수익률 1 이상(이익) 테스트")
	void resultYieldSuccessLottoTest() {
		lottoPackage.add(Lotto.generateLotto("1,2,3,4,5,45"));

		manualLotto = new ManualLotto(lottoPackage);
		lottoGame = new Game(manualLotto, 0);

		LottoResult result = lottoGame.getLottoResult(winnerLotto);

		assertThat(result.report(new GameCondition("2000", "0"))).isGreaterThan(new BigDecimal(1));
	}

	@Test
	@DisplayName("로또 결과: 수익률 1 이하(손해) 테스트")
	void resultYieldFailLottoTest() {
		lottoPackage.add(Lotto.generateLotto("1,10,17,30,40,41"));
		lottoPackage.add(Lotto.generateLotto("1,10,18,31,40,42"));
		lottoPackage.add(Lotto.generateLotto("1,10,19,32,40,43"));
		lottoPackage.add(Lotto.generateLotto("1,10,20,33,40,44"));
		lottoPackage.add(Lotto.generateLotto("1,10,21,34,40,45"));

		manualLotto = new ManualLotto(lottoPackage);
		lottoGame = new Game(manualLotto, 0);

		LottoResult result = lottoGame.getLottoResult(winnerLotto);

		assertThat(result.report(new GameCondition("6000", "0"))).isLessThan(new BigDecimal(1));
	}

	@Test
	@DisplayName("로또 결과: 수익률 0 테스트")
	void resultYieldZeroLottoTest() {
		manualLotto = new ManualLotto(lottoPackage);
		lottoGame = new Game(manualLotto, 0);

		LottoResult result = lottoGame.getLottoResult(winnerLotto);
		assertThat(result.report(new GameCondition("1000", "0"))).isZero();
	}

	@Test
	@DisplayName("로또 결과: 로또 결과 객체 생성 테스트")
	void initLottoResultTest() {
		manualLotto = new ManualLotto(lottoPackage);
		lottoGame = new Game(manualLotto, 0);
		
		LottoResult result = lottoGame.getLottoResult(winnerLotto);
		assertThat(result).isNotNull();
	}
}

