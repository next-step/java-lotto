package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTest {
	@ParameterizedTest
	@DisplayName("로또 번호는 1~45 사이의 수이다.")
	@MethodSource("provideLottos")
	public void getLottoNumbersTest(Lotto lotto, LottoNumber expected) {
		assertThat(lotto.getNumbers()).hasSize(6);
		assertAll(() -> assertFalse(lotto.getNumbers().contains(expected)),
				() -> assertFalse(lotto.getNumbers().contains(expected)));
	}

	@ParameterizedTest
	@DisplayName("로또 당첨번호에서 공백을 제거한다.")
	@MethodSource("provideLastWeekLotto")
	public void inpuLastLottoNumberTest(Lotto lotto, LottoNumber expected) {
		assertTrue(lotto.getNumbers().contains(expected));
		assertTrue(lotto.getNumbers().contains(expected));
	}

	private static Stream<Arguments> provideLottos() {
		return Stream.of(
				Arguments.of(MockLotto.mockLotto(Arrays.asList(1,2,3,4,5,6)), new LottoNumber(7)),
				Arguments.of(MockLotto.mockLotto(Arrays.asList(1,2,3,4,5,7)), new LottoNumber(8))
		);
	}

	private static Stream<Arguments> provideLastWeekLotto() {
		return Stream.of(
				Arguments.of(new Lotto().getLastWeekLotto("1,2,3,4, 5,  6"), new LottoNumber(5)),
				Arguments.of(new Lotto().getLastWeekLotto("1,2,3,4,  40,  45"), new LottoNumber(45))
		);
	}
}
