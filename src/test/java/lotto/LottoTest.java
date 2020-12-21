package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {

	@DisplayName("로또가 정상적으로 생성되는지 확인한다.")
	@Test
	void createTest() {
		List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6);
		Lotto lotto = Lotto.of(source);

		assertThat(lotto.isSameLottoNumbers(source)).isTrue();
	}

	@DisplayName("2개의 로또의 번호들을 정상적으로 비교하는지 확인한다.")
	@ParameterizedTest
	@MethodSource("provideTwoNumbersAndResult")
	void compareTest(List<Integer> source1, List<Integer> source2, int count) {
		Lotto lotto1 = Lotto.of(source1);
		Lotto lotto2 = Lotto.of(source2);

		assertThat(lotto1.compare(lotto2)).isEqualTo(count);
	}

	private static Stream<Arguments> provideTwoNumbersAndResult() {
		return Stream.of(
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 6),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(7, 8, 9, 10, 11, 12), 0),
			Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(45, 44, 43, 1, 2, 3), 3)
		);
	}
}
