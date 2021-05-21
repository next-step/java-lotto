package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("랜덤한 로또번호 생성 테스트")
public class RandomNumbersGeneratorTest {

	@Test
	@DisplayName("랜덤하게 생성한 로또번호가 6개인지 테스트")
	void testRandomNumbers() {
		TestRandomNumbersGenerator generator = new TestRandomNumbersGenerator();
		for (int i = 0; i < 8; i++) {
			List<Integer> numbers = generator.generateNumbers();
			Assertions.assertThat(numbers).hasSize(6);
		}
	}

	@Test
	@DisplayName("랜덤하게 생성한 로또번호가 6개인지 테스트")
	void lottoRandomNumbers() {
		LottoRandomNumbersGenerator generator = new LottoRandomNumbersGenerator();
		List<Integer> numbers = generator.generateNumbers();
		Assertions.assertThat(numbers).hasSize(6);
	}

}
