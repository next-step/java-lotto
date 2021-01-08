package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
	@ParameterizedTest
	@ValueSource(ints = {0, 46})
	@DisplayName("로또 번호가 1~45를 넘어 가면 IllegalArgumentException이 발생한다.")
	void validateLottoNumber_test(int number) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoNumber.of(number))
			.withMessage(Message.INVALID_LOTTO_NUMBER_RANGE);
	}

	@Test
	@DisplayName("비교 숫자보다 크면 1을 리턴한다.")
	void compare_greater_test() {
		LottoNumber greater = LottoNumber.of(20);
		LottoNumber less = LottoNumber.of(1);

		assertThat(greater.compare(less))
			.isGreaterThan(0);
	}

	@Test
	@DisplayName("비교 숫자보다 작으면 -1을 리턴한다.")
	void compare_less_test() {
		LottoNumber less = LottoNumber.of(1);
		LottoNumber greater = LottoNumber.of(20);

		assertThat(less.compare(greater))
			.isLessThan(0);
	}
}
