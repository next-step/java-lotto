package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersGeneratorTest {

	@Test
	@DisplayName("랜덤하게 여러 LottoNumbers 를 만들어 낼 수 있다.")
	public void generateLottNumbersTest() {
		int numbersCount = 10;

		List<LottoNumbers> lottoNumbers = LottoNumbersGenerator.generateRandomly(numbersCount);

		assertThat(lottoNumbers.size()).isEqualTo(numbersCount);
	}
}
