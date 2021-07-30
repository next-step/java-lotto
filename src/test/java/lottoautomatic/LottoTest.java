package lottoautomatic;

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

class LottoTest {

	@Test
	@DisplayName("로또는 6개의 번호를 가진다.")
	void lotto_has_6_numbers() throws Exception {
		//given
		Lotto lotto = new Lotto();
		List<Integer> defaultNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		//when
		lotto.generateNumbers(() -> defaultNumbers);
		List<Integer> numbers = lotto.numbers();

		//then
		assertThat(numbers).hasSize(defaultNumbers.size());
	}


	@Test
	@DisplayName("로또의 번호가 6개가 아닌 경우 예외")
	void lotto_number_size_exception() throws Exception {
		//given
		Lotto lotto = new Lotto();

		//when
		List<Integer> defaultNumbers = Arrays.asList(1, 2, 3, 4, 5);

		//then
		assertThatThrownBy(() -> lotto.generateNumbers(() -> defaultNumbers)).isInstanceOf(IllegalStateException.class);
	}



	@ParameterizedTest
	@MethodSource("matchNumbers")
	@DisplayName("지난주 당첨 번호와 비교")
	void match_numbers(List<Integer> lottoNumbers, int matchedCount) throws Exception {
		//given
		Lotto lotto = new Lotto();
		List<Integer> lastWeekNumbers = Arrays.asList(1,2,3,4,5,6);

		//when
		lotto.generateNumbers(() -> lottoNumbers);
		int matchesNumber = lotto.match(lastWeekNumbers);

		//then
		assertThat(matchesNumber).isEqualTo(matchedCount);
	}

	private static Stream<Arguments> matchNumbers() {
		return Stream.of(
			Arguments.of(Arrays.asList(1,2,3,4,5,6), 6),
			Arguments.of(Arrays.asList(1,2,3,4,5,11), 5),
			Arguments.of(Arrays.asList(1,2,3,4,11,12), 4),
			Arguments.of(Arrays.asList(1,2,3,11,12,13), 3)
		);
	}

}
