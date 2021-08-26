package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

	@Test
	@DisplayName("1~45까지 유효범위 검사")
	void scope() {
		assertThatThrownBy(() -> {
			LottoNumber n1 = new LottoNumber(0);
		}).isExactlyInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			LottoNumber n2 = new LottoNumber(46);
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
