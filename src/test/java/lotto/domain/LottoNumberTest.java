package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
	@ParameterizedTest
	@ValueSource(ints = {0, 46})
	@DisplayName("로또 번호가 1~45를 넘어 가면 IllegalArgumentException이 발생한다.")
	void validateLottoNumberTest(int number) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new LottoNumber(number))
			.withMessage(Message.INVALID_LOTTO_NUMBER_RANGE);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 45})
	@DisplayName("로또 번호가 1~45사이이면 Number를 생성한다.")
	void createTest(int number) {
		assertThat(new LottoNumber(number))
			.isInstanceOf(LottoNumber.class)
			.isNotNull();
	}
}
