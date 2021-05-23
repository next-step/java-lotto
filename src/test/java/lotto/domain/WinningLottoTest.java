package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {

	@DisplayName("유효성 체크 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"", "   ", "1,2,3", "sdfsdf", "1,2,3,3,3,3", "1,2,3,4,5,99", "1,2,3,4,5,6   ",
		"    1,2,3 ,4,   5 ,6"})
	void invalid(String number) {
		// then
		assertThatThrownBy(() -> new WinningLotto(number)).isInstanceOf(IllegalArgumentException.class);
	}

}
