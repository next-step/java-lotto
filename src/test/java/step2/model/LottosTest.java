package step2.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.Lottos;
import step2.util.RandomLottoGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottosTest {

	Lottos lottos;
	RandomLottoGenerator randomLottoGenerator;

	@ParameterizedTest
	@ValueSource(ints = {15000, 1000, 20000})
	void LottoTicketCntTest(int money) {
		lottos = new Lottos(money, randomLottoGenerator);
		assertEquals(lottos.getTicketCnt(), money / 1000);
	}
}