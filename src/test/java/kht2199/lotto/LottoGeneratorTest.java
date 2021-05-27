package kht2199.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import kht2199.lotto.data.Lotto;

/**
 *
 * @author heetaek.kim
 */
class LottoGeneratorTest {

	LottoGenerator generator = new LottoGenerator();

	@RepeatedTest(value = 100)
	@DisplayName("로또 번호 생성")
	void random() {
		Lotto random = generator.random();
		List<Integer> numbers = random.getNumbers();
		assertThat(numbers)
			.allMatch(v -> v >= 1 && v <= 46)
			.doesNotHaveDuplicates()
			.hasSize(6);
	}
}