package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

	LottoNumbers createNumbers(List<Integer> numbers) {
		return new LottoNumbers(numbers);
	}

	@Test
	@DisplayName("동일한 숫자 갯수")
	void match() {
		assertThat(createNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)).matchedCount(
			createNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(6);

		assertThat(createNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)).matchedCount(
			createNumbers(Arrays.asList(7, 8, 9, 10, 11, 12)))).isEqualTo(0);
	}
}
