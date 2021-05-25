package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PrizeTest {

	@ParameterizedTest
	@CsvSource(value = {"6,2000000000", "5,1500000", "4,50000", "3, 5000", "2, 0", "1, 0", "0, 0"}, delimiter = ',')
	@DisplayName("당첨 금액 매치 테스트")
	void match(int count, long win) {
		assertThat(Prize.findByCount(count).win()).isEqualTo(new Money(win));
	}
}
