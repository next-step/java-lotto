package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMachineTest {

	@DisplayName("금액에 해당하는 만큼의 로또를 구매한다.")
	@ParameterizedTest
	@CsvSource({ "1000,1", "15000,15", "500,0" })
	void purchaseLotto(int money, int expected) {
		LottoMachine lottoMachine = new LottoMachine(money);
		assertThat(lottoMachine.getPurchasedLotto().lottoCount()).isEqualTo(expected);
	}

}
