package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

	@DisplayName("로또 넘버가 캐싱되는지 확인")
	@Test
	void test1() {
		assertThat(LottoNumber.of(1) == LottoNumber.of(1)).isTrue();
	}

	@DisplayName("로또 넘버 예외 케이스 - 범위를 벗어남")
	@ValueSource(ints = {0, 46})
	@ParameterizedTest
	void test2(int input) {
		assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(input));
	}

	@DisplayName("로또 넘버 예외 케이스 - 숫자가 아님")
	@ValueSource(strings = {"a", "b"})
	@ParameterizedTest
	void test3(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(input));
	}
}
