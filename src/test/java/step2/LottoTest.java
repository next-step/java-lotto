package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

	@DisplayName(value = "입력받은 금액에서 발급할 수 있는 로또 갯수 구하는 기능")
	@Test
	void howManyLotto() {
		int result = Lotto.getLottoCountByPrice(14000);
		assertThat(result).isEqualTo(14);
	}
}
