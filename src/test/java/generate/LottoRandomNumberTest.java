package generate;

import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;

import static domain.Lotto.LOTTO_NUMBER_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRandomNumberTest {

	@RepeatedTest (100)
	public void 로또번호자동생성 () {
		LottoRandomNumber lottoRandomNumber = new LottoRandomNumber();

		List<Integer> randomNumbers =lottoRandomNumber.numbers(getRandomNumber(LOTTO_NUMBER_LENGTH));

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

	private List<Integer> getRandomNumber(Integer length) {
		List<Integer> randoms = new ArrayList<>();
		randoms.add(1);
		randoms.add(2);
		randoms.add(3);
		randoms.add(4);
		randoms.add(5);
		randoms.add(6);

		return randoms;
	}
}