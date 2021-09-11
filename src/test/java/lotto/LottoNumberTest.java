package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

	@Test
	@DisplayName("1 ~ 45의 숫자만 유효함")
	void scope() {
		assertThatThrownBy(() -> {
			new LottoNumber(0);
		}).isExactlyInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			new LottoNumber(46);
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
