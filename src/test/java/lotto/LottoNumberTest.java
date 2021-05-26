package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

	@DisplayName("로또 숫자 값이 1보다 작거나 45보다 큰 경우, 에러가 발생한다.")
	@ValueSource(ints = { -1, 0, 46 })
	@ParameterizedTest
	void LottoNumber(int param) {
		assertThatThrownBy(() -> new LottoNumber(param)).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("로또 번호는 0보다 작거나 45보다 클 수 없습니다.");
	}
}
