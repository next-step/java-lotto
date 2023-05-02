package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningMoneyTest {

	@DisplayName("당첨 금액 예외 케이스 - 음수")
	@Test
	void test1() {
		assertThatIllegalArgumentException().isThrownBy(() -> new WinningMoney(-1000));
	}
}
