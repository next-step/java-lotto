package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StoreTest {
	
	@ParameterizedTest
	@CsvSource(value = {"1000:1", "1200:1", "1900:1", "0:0", "3000:3"}, delimiter = ':')
	@DisplayName("구매 테스트")
	void buy(long amount, int expected) {
		Lottos lottos = Store.buy(new Money(amount));
		assertThat(lottos.count()).isEqualTo(expected);
	}
}
