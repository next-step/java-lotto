package lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberAutoGeneratorTest {
	List<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = LottoNumberAutoGenerator.generate();
	}

	@Test
	@DisplayName("로또 번호는 6개의 숫자여야 한다")
	void generatedLottoNumberSizeTest() {
		assertThat(numbers.size()).isEqualTo(6);
	}

	@Test
	@DisplayName("로또 번호는 1에서 45사이의 숫자여야 한다")
	void generatedLottoNumberRangeTest() {
		assertThat(numbers).allMatch(number -> number <= 45 && number >= 1);
	}

	@Test
	@DisplayName("생성된 로또 번호는 오름차순으로 정렬되어야한다")
	void generatedLottoNumberSortTest() {
		for (int i = 1; i < numbers.size(); i++) {
			assertThat(numbers.get(i)).isGreaterThan(numbers.get(i-1));
		}
	}
}
