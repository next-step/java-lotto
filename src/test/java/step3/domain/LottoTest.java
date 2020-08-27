package step3.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
	private static Lotto winningLotto;
	private static List<LottoNumber> winningNumbers;

	private static Stream<Arguments> provideLottoNumbers() {
		return Stream.of(
				Arguments.of(new int[] {3, 6, 10, 14, 16, 40}, 6),
				Arguments.of(new int[] {1, 3, 28, 30, 31, 40}, 2),
				Arguments.of(new int[] {10, 14, 16, 30, 31, 40}, 4),
				Arguments.of(new int[] {14, 19, 21, 29, 30, 40}, 2),
				Arguments.of(new int[] {3, 9, 10, 18, 19, 30}, 2),
				Arguments.of(new int[] {5, 6, 13, 14, 16, 38}, 3),
				Arguments.of(new int[] {3, 6, 10, 14, 16, 38}, 5)
		);
	}

	@BeforeAll
	static void setWinningLotto() {
		int[] winning = new int[] {3, 6, 10, 14, 16, 40};
		winningNumbers = Arrays.stream(winning)
				.mapToObj(LottoNumber::new)
				.collect(Collectors.toList());
		winningLotto = new Lotto(winningNumbers);
	}

	@DisplayName(value = "당첨 번호와 일치하는 개수 테스트")
	@ParameterizedTest
	@MethodSource("provideLottoNumbers")
	void getMatchCount(int[] numbers, int expected) {
		List<LottoNumber> lottoNumbers= Arrays.stream(numbers)
				.mapToObj(LottoNumber::new)
				.collect(Collectors.toList());
		Lotto lotto = new Lotto(lottoNumbers);

		assertThat(lotto.getMatchCount(winningNumbers)).isEqualTo(expected);
	}

	@DisplayName(value = "전달 받은 번호와 일치하는 번호가 있는지 테스트")
	@ParameterizedTest
	@CsvSource(value = {"3:true", "6:true", "10:true", "35:false"}, delimiter = ':')
	void containNumber(int value, boolean expected) {
		assertThat(winningLotto.containNumber(new LottoNumber(value))).isEqualTo(expected);
	}
}