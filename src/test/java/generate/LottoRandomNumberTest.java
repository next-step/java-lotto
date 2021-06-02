package generate;

import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRandomNumberTest {

	@RepeatedTest (100)
	public void 로또번호자동생성 () {
		List<Integer> randomNumbers = LottoRandomNumber.numbers();

		assertThat(randomNumbers.size()).isEqualTo(6);

		assertThat(randomNumbers)
				.containsOnlyOnce(
						randomNumbers.get(0),
						randomNumbers.get(1),
						randomNumbers.get(2),
						randomNumbers.get(3),
						randomNumbers.get(4),
						randomNumbers.get(5)
				);
	}
}