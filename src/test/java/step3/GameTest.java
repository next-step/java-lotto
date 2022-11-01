package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameTest {

	@Test
	@DisplayName("최소 금액 예외")
	void minAmount() {
		assertThatThrownBy(() -> Game.start(999))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("최소 금액은 1000원 입니다");
	}

	@ParameterizedTest
	@DisplayName("구입금액에 따라 로또 개수 확인")
	@CsvSource(value = {
		"10000:10",
		"3000:3"
	}, delimiter = ':')
	void inputAmountOfLotto(int lottoByMoney, int lotto) {
		assertThat(Game.startRaffle(new LottoAmount(lottoByMoney)).lottoList().size()).isEqualTo(lotto);
	}
}
