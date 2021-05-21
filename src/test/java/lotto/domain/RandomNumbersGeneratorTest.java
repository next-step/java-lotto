package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("랜덤한 로또번호 생성 테스트")
public class RandomNumbersGeneratorTest {

	@Test
	@DisplayName("테스트용 랜덤번호 생성기 테스트 - 로또번호가 6개인지 테스트")
	void generateTestRandomNumbers() {
		TestRandomNumbersGenerator generator = new TestRandomNumbersGenerator(new Integer[]{1, 2, 3, 4, 5, 6});
		List<Integer> numbers = generator.generateNumbers();
		Assertions.assertThat(numbers).hasSize(6);
	}

	@Test
	@DisplayName("랜덤번호 생성기 테스트 - 로또번호가 6개인지 테스트")
	void generateLottoRandomNumbers() {
		LottoRandomNumbersGenerator generator = new LottoRandomNumbersGenerator();
		List<Integer> numbers = generator.generateNumbers();
		Assertions.assertThat(numbers).hasSize(6);
	}

}
