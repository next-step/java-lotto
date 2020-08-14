package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.domain.Number;
import step1.exception.StringAdderException;
import step2.LottoException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

	@ParameterizedTest
	@CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
	void testConstruct(String stringInput, int intInput) {
		assertThat(new LottoNumber(stringInput)).isEqualTo(new LottoNumber(intInput));
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "a"})
	void failTestConstruct(String stringInput) {
		assertThrows(LottoException.class, () -> new LottoNumber(stringInput));
	}

	@ParameterizedTest
	@CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
	void testToString(String stringInput, String expect) {
		assertThat(new LottoNumber(stringInput).toString()).isEqualTo(expect);
	}

}