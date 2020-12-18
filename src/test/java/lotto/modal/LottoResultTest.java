package lotto.modal;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

	private List<Lotto> lottoPackage;
	private WinnerLotto winnerLotto;

	@BeforeEach
	void init() {

		lottoPackage = new ArrayList<>();
		lottoPackage.add(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "10", "20", "30", "40", "45"))));

		winnerLotto = new WinnerLotto(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "6"))),
			new LottoNumber("7"));
	}

	@Test
	@DisplayName("로또 결과: 1등 4번, Overflow 테스트")
	void resultOverYieldSuccessLottoTest() {

		lottoPackage.add(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "45"))));
		lottoPackage.add(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "6"))));
		lottoPackage.add(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "6"))));
		lottoPackage.add(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "6"))));
		lottoPackage.add(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "6"))));

		LottoResult result = new LottoResult(lottoPackage, winnerLotto);

		assertThat(result.report(new Money("6000"))).isGreaterThan(new BigDecimal(1));
	}

	@Test
	@DisplayName("로또 결과: 수익률 1 이상(이익) 테스트")
	void resultYieldSuccessLottoTest() {

		lottoPackage.add(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "4", "5", "45"))));

		LottoResult result = new LottoResult(lottoPackage, winnerLotto);

		assertThat(result.report(new Money("2000"))).isGreaterThan(new BigDecimal(1));
	}

	@Test
	@DisplayName("로또 결과: 수익률 1 이하(손해) 테스트")
	void resultYieldFailLottoTest() {

		lottoPackage.add(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "10", "21", "30", "40", "45"))));
		lottoPackage.add(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "10", "21", "30", "40", "45"))));
		lottoPackage.add(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "10", "21", "30", "40", "45"))));
		lottoPackage.add(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "2", "20", "30", "40", "45"))));
		lottoPackage.add(new Lotto(Lotto.generateManualLotto(Arrays.asList("1", "2", "3", "30", "40", "45"))));

		LottoResult result = new LottoResult(lottoPackage, winnerLotto);

		assertThat(result.report(new Money("6000"))).isLessThan(new BigDecimal(1));
	}

	@Test
	@DisplayName("로또 결과: 수익률 0 테스트")
	void resultYieldZeroLottoTest() {

		LottoResult result = new LottoResult(lottoPackage, winnerLotto);

		assertThat(result.report(new Money("1000"))).isZero();
	}

	@Test
	@DisplayName("로또 결과: 로또 결과 객체 생성 테스트")
	void initLottoResultTest() {

		LottoResult result = new LottoResult(lottoPackage, winnerLotto);

		assertThat(result).isNotNull();
	}
}

