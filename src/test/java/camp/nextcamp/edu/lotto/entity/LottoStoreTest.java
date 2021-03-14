package camp.nextcamp.edu.lotto.entity;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextcamp.edu.lotto.exception.UserException;
import camp.nextcamp.edu.lotto.exception.UserExceptionMesssage;

public class LottoStoreTest {

	@Test
	@DisplayName("가격 총 갯수 테스트")
	void price_all_test() {
		// given
		LottoStore lottoStore = new LottoStore("10000", Arrays.asList("1, 2, 3, 4, 5, 6"));

		// then
		assertThat(lottoStore.getTotalMoney())
			.isEqualTo(10000);
	}

	@Test
	@DisplayName("가격 숫자가 아닌것 exception")
	void price_not_numeric() {
		assertThatExceptionOfType(UserException.class)
			.isThrownBy(() -> new LottoStore("10a00", Arrays.asList("1, 2, 3, 4, 5, 6")))
			.withMessageMatching(UserExceptionMesssage.ONLY_NUMBER.getMessage());
	}


}
