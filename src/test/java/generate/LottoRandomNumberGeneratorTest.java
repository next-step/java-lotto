package generate;

import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.Lotto.LOTTO_NUMBER_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRandomNumberGeneratorTest {

	@Test
	public void 로또번호자동생성() {
		LottoRandomNumberGenerator lottoGenerator = new DefaultLottoRandomNumberGenerator();

		List<Integer> randomNumbers = lottoGenerator.randomNumber(LOTTO_NUMBER_LENGTH);

		assertThat(6).isEqualTo(randomNumbers.size());

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