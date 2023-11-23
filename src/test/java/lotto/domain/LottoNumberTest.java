package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
	@DisplayName("로또 번호가 1미만 45초과의 값을 가질 시 IllegalArgumentException를 발생시킨다.")
	@ParameterizedTest
	@ValueSource(ints = {0, 46})
	void valid_lotto_num(int num) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoNumber(num));
	}
}
