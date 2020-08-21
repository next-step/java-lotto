package step2_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2_3.domain.Lotto;
import step2_3.domain.LottoIssuer;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

	@DisplayName(value = "로또 구입 금액에 오류가 있을 때 에러 처리 테스트")
	@ParameterizedTest
	@ValueSource(ints = {0, 500, 1500, 3256})
	void validPrice(int price) {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> Validator.validPrice(price))
				.withMessage("로또 구입 금액은 1000원 단위만 가능합니다.");
	}

	@DisplayName(value = "로또 당첨 번호 에러 처리 테스트")
	@Test
	void validWinningNumbers() {
		assertThatThrownBy(() -> Validator.validWinningNumbers(new Lotto(Arrays.asList(1, 1))))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("로또 당첨 번호는 1~45 중 중복되지 않는 여섯 개의 숫자로 이루어져야 합니다.");

	}

	@DisplayName(value = "로또 보너스 당첨 번호 에러 처리 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 4, 50, 100})
	void validBonusBallNumber(int bonus) {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> Validator.validBonusBallNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), bonus));
	}
}