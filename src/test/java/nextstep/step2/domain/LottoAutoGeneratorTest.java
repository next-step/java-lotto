package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoAutoGeneratorTest {
	@Test
	@DisplayName("로또 자동번호는 1~45 사이의 수이다.")
	public void getLottoRandomNumberTest() {
		Lotto lotto = LottoAutoGenerator.getAutoNumbers();
		lotto.getNumbers().forEach(number -> {
			assertAll(() -> assertTrue(number.compareTo(LottoNumber.of(LottoNumber.LOTTO_MIN_NUMBER)) >= 0),
					() -> assertTrue(number.compareTo(LottoNumber.of(LottoNumber.LOTTO_MAX_NUMBER)) <= 0));
		});
	}

	@Test
	@DisplayName("로또 자동번호는 불변객체이다.")
	public void getLottoNumberImmutableTest() {
		Lotto lotto = LottoAutoGenerator.getAutoNumbers();
		Assertions.assertThatExceptionOfType(UnsupportedOperationException.class)
				.isThrownBy(() -> lotto.getNumbers().add(LottoNumber.of(1)));
	}
}
