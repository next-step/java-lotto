package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoDrawerTest {
	@ParameterizedTest(name = "[{index}] 입력받은 가격 {0} 만큼의 로또 {1}장을 발행한다")
	@CsvSource(value = {"500:0", "1000:1", "5000:5", "14000:14", "14500:14", "16100:16", "19122140:19122"}, delimiter = ':')
	void drawLottosTest(int money, int numberOfLottos) {
		BigDecimal receivedMoney = BigDecimal.valueOf(money);
		LottoDrawer lottoDrawer = new LottoDrawer();

		Lottos lottos = lottoDrawer.draw(receivedMoney);
		assertThat(lottos.lottos().size()).isEqualTo(numberOfLottos);
	}

	@Test
	@DisplayName("로또 번호를 생성한다")
	void drawLottoTest() {
		LottoDrawer lottoDrawer = new LottoDrawer();
		Lotto lotto = lottoDrawer.draw();
		assertThat(lotto.numbers().size()).isEqualTo(6);
	}
}
