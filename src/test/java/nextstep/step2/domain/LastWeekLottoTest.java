package nextstep.step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LastWeekLottoTest {
	@Test
	@DisplayName("지난주 로또 당첨번호는 숫자여야 한다")
	public void inputWrongLastLottoNumberTest() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new LastWeekLotto().validateLastWinnerNumbers("1,2,3,a,b,c".split(",")))
				.withMessage("지난주 로또 당첨번호는 모두 숫자여야 합니다.");
	}

	@ParameterizedTest
	@DisplayName("로또 당첨번호에서 공백을 제거한다.")
	@MethodSource("provideLastWeekLotto")
	public void inpuLastLottoNumberTest(Lotto lotto, LottoNumber expected) {
		assertTrue(lotto.getNumbers().contains(expected));
		assertTrue(lotto.getNumbers().contains(expected));
	}

	private static Stream<Arguments> provideLastWeekLotto() {
		return Stream.of(
				Arguments.of(new LastWeekLotto().getLastWeekLotto("1,2,3,4, 5,  6"), new LottoNumber(5)),
				Arguments.of(new LastWeekLotto().getLastWeekLotto("1,2,3,4,  40,  45"), new LottoNumber(45))
		);
	}
}
