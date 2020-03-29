package sum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositiveValuesTest {

	@Test
	@DisplayName("기본 테스트")
	void sum() {
		PositiveValues positiveValues = new PositiveValues("1", "2", "3");
		assertThat(positiveValues.sum())
				.isEqualTo(6);
	}

	@Test
	@DisplayName("객체 테스트")
	void objectTest() {
		assertThat(new PositiveValues("1", "2", "3"))
				.isEqualTo(new PositiveValues("1", "2", "3"));
	}

	@ParameterizedTest
	@NullSource
	@EmptySource
	@DisplayName("빈 값 처리 테스트")
	void exceptionTest(String emptyValue) {
		assertThat(new PositiveValues(emptyValue).sum())
				.isEqualTo(0);
	}

}