package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoAutoGeneratorTest {
	private LottoAutoGenerator underTest = new LottoAutoGenerator();
	@Test
	@DisplayName("로또 자동번호는 1~45 사이의 수이다.")
	public void getLottoRandomNumberTest() {
		List<Integer> autoNumbers = underTest.getAutoNumbers();
		autoNumbers.forEach(number -> {
			assertAll(() -> assertTrue(number <= 45),
					() -> assertTrue(number > 0));
		});
	}

	@Test
	@DisplayName("로또 자동번호는 불변객체이다.")
	public void getLottoNumberImmutableTest() {
		List<Integer> autoNumbers = new LottoAutoGenerator().getAutoNumbers();
		Assertions.assertThatExceptionOfType(UnsupportedOperationException.class)
				.isThrownBy(() -> autoNumbers.add(1));
	}
}
