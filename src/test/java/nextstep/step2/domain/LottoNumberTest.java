package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

	@Test
	@DisplayName("로또번호는 숫자여야 한다")
	public void inputWrongLastLottoNumberTest() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> LottoNumber.getValidateNumber("abc"))
				.withMessage("로또번호는 모두 숫자여야 합니다.");
	}
}
