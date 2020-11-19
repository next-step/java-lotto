package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LottoTest {
	@ParameterizedTest
	@DisplayName("로또 번호는 1~45 사이의 수이다.")
	@MethodSource("provideLottos")
	public void getLottoNumbersTest(Lotto lotto, int expected) {
		assertThat(lotto.getNumbers()).hasSize(6);
		assertAll(() -> assertFalse(lotto.getNumbers().contains(expected)),
				() -> assertFalse(lotto.getNumbers().contains(expected)));
	}

	private static Stream<Arguments> provideLottos() {
		return Stream.of(
				Arguments.of(MockLotto.mockLotto(Arrays.asList(1,2,3,4,5,6)), 0),
				Arguments.of(MockLotto.mockLotto(Arrays.asList(1,2,3,4,5,6)), 46)
		);
	}
}
