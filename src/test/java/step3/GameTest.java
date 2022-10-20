package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

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
		"10:10",
		"3:3"
	}, delimiter = ':')
	void inputAmountOfLotto(int lottoByMoney, int lotto) {
		assertThat(Game.startRaffle(lottoByMoney).getList().size()).isEqualTo(lotto);
	}

	@Test
	@DisplayName("지난 주 당첨 번호 생성")
	void makeWinningNumbers() {
		String str = "1, 2, 3, 4, 5, 6";
		int bonus = 7;
		assertThat(Game.makeWinningResult(str.split(", "))).isEqualTo(Set.of(1, 2, 3, 4, 5, 6));
	}
}
