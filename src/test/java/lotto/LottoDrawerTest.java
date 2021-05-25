package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoDrawerTest {
	@ParameterizedTest(name = "[{index}] 입력받은 가격 {0} 만큼의 로또 {1}장을 발행한다")
	@CsvSource(value = {"1000:1", "5000:5", "14000:14", "14500:14", "16100:16", "19122140:19122"}, delimiter = ':')
	void drawLottosTest(int money, int numberOfLottos) {
		BigDecimal receivedMoney = BigDecimal.valueOf(money);

		Lottos lottos = LottoDrawer.draw(receivedMoney);
		assertThat(lottos.lottos().size()).isEqualTo(numberOfLottos);
	}

	@Test
	@DisplayName("로또 번호를 생성한다")
	void drawLottoTest() {
		Lotto lotto = LottoDrawer.draw();
		assertThat(lotto.numbers().size()).isEqualTo(6);
	}

	@Test
	@DisplayName("1000원 미만의 돈을 입력받으면 익셉션이 발생한다")
	void lackOfMoneyTest() {
		BigDecimal receivedMoney = BigDecimal.valueOf(500);
		assertThatThrownBy(() -> LottoDrawer.draw(receivedMoney))
				.isInstanceOf(RuntimeException.class);
	}
}
