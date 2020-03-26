package sum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValueListTest {

	@Test
	@DisplayName("기본 테스트")
	void sum() {
		ValueList valueList = new ValueList("1", "2", "3");
		assertThat(valueList.sum())
				.isEqualTo(6);
	}

	@Test
	@DisplayName("객체 테스트")
	void objectTest() {
		assertThat(new ValueList("1", "2", "3"))
				.isEqualTo(new ValueList("1", "2", "3"));
	}

	@Test
	@DisplayName("예외 테스트")
	void exceptionTest() {
		assertThatThrownBy(() -> new ValueList("1", "", "3"))
				.isInstanceOf(RuntimeException.class);

		assertThatThrownBy(() -> new ValueList("1", "2", null))
				.isInstanceOf(RuntimeException.class);
	}

}