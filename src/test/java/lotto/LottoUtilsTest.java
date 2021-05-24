package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoUtilsTest {

	@Test
	void randomLottoNumbers() {
		List<Number> numbers = LottoUtils.getRandomNumbers();
		assertThat(numbers.size()).isEqualTo(6);
		assertThat(numbers.stream()
					.distinct()
					.count()
		).isEqualTo(6);
	}
}
