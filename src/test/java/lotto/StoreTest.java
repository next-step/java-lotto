package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StoreTest {
	
	@ParameterizedTest
	@CsvSource(value = {"1000:1", "1200:1", "1900:1", "0:0", "3000:3"}, delimiter = ':')
	@DisplayName("구매 테스트 : 자동")
	void buy(long amount, int expected) {
		Lottos lottos = Store.buy(new Money(amount), new ArrayList<>());
		assertThat(lottos.count()).isEqualTo(expected);
	}

	@Test
	@DisplayName("구매 테스트 : 수동")
	void buyManual() {
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(12, 18, 22, 26, 36, 37));
		list.add(Arrays.asList(5, 22, 31, 32, 36, 37));
		list.add(Arrays.asList(13, 24, 26, 33, 41, 42));

		Lottos lottos = Store.buy(new Money(3000), list);
		assertThat(lottos.count()).isEqualTo(3);
		assertThat(lottos.allNumbers()).containsAnyElementsOf(list);

		assertThatIllegalArgumentException().isThrownBy(() ->  Store.buy(new Money(2000), list))
			.withMessage("수동으로 살 수 있는 금액을 넘었습니다.");
	}

}
