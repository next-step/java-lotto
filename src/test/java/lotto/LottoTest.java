package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
	@Test
	@DisplayName("당첨번호와 일치하는 숫자의 개수를 반환한다")
	void checkWinningTest() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
		List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
		LottoPrizeType matchedNumber = lotto.checkWinning(winningNumber);
		assertThat(matchedNumber).isEqualTo(LottoPrizeType.FIVE_MATCHED);
	}

	@Test
	@DisplayName("로또번호는 6자리여야 한다")
	void lottoLengthLimitTest() {
		assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
				.isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest(name = "[{index}] 로또 번호는 1~45사이의 숫자여야 한다")
	@MethodSource(value = "generateLottoNumber")
	void lottoNumberLimitTest(List<Integer> lottoNumbers) {
		assertThatThrownBy(() -> new Lotto(lottoNumbers))
				.isInstanceOf(RuntimeException.class);
	}

	private static Stream<Arguments> generateLottoNumber() {
		return Stream.of(
				Arguments.of(Arrays.asList(-1, 2, 3, 5, 45, 40)),
				Arguments.of(Arrays.asList(1, 2, 3, 5, 45, 60)),
				Arguments.of(Arrays.asList(-1, 2, 3, 5, 45, 60))
		);
	}
}
