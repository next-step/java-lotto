package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.domain.Number;
import step1.exception.StringAdderException;
import step2.LottoException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

	@DisplayName("객체 생성 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
	void testConstruct(String stringInput, int intInput) {
		assertThat(new LottoNumber(stringInput)).isEqualTo(new LottoNumber(intInput));
	}

	@DisplayName("객체 생성 실패 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "a", "46"})
	void failTestConstruct(String stringInput) {
		assertThrows(LottoException.class, () -> new LottoNumber(stringInput));
	}

	@DisplayName("toString 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
	void testToString(String stringInput, String expect) {
		assertThat(new LottoNumber(stringInput).toString()).isEqualTo(expect);
	}

}