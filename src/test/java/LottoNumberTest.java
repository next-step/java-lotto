import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

	@ParameterizedTest
	@CsvSource(value = {
		"1,1,true", "1,0,false"
	})
	void equalsTest(final int sourceNumber, final int targetNumber, final boolean expected) {
		// given
		LottoNumber source = new LottoNumber(sourceNumber);
		LottoNumber target = new LottoNumber(targetNumber);

		assertThat(source.equals(target))
			.isEqualTo(expected);
	}



	@ParameterizedTest(name = "CompareTo 테스트, source[{0}], target[{1}], expected[{2}]")
	@CsvSource(value = {
		"1, 2, -1", "2, 1, 1", "2, 2, 0"
	})
	void compareToTest(final int sourceNumber, final int targetNumber, final int expected) {
		// given
		LottoNumber source = new LottoNumber(sourceNumber);
		LottoNumber target = new LottoNumber(targetNumber);

		// when
		assertThat(source.compareTo(target))
			.isEqualTo(expected); // then
	}
}
