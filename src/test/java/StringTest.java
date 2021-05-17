import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName("split() 메서드는 특정 문자를 기준으로 문자열을 분리해 배열로 반환한다.")
	public void splitMultipleValuesTest() {
		// given
		String source = "1,2";

		// when
		String[] split = source.split(",");

		// then
		assertThat(split).contains("1", "2");
	}

	@Test
	@DisplayName("split() 메서드가 특정 문자를 기준으로 문자열을 분리할 때 특정 문자가 포함되지 않는다면 원래 문자열만 담긴 배열이 반환된다.")
	public void splitOneValueTest() {
		// given
		String source = "1";

		// when
		String[] split = source.split(",");

		// then
		assertThat(split).containsExactly("1");
	}

	@Test
	@DisplayName("subString() 메서드는 문자열의 위치를 사용해 문자열 일부를 뽑아낼 수 있다")
	public void subStringTest() {
		// given
		String source = "(1,2)";

		// when
		String substring = source.substring(1, 4);

		// then
		assertThat(substring).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt() 메소드는 문자열의 특정 위치를 가지고 와야 한다.")
	public void charAtTest() {
		// given
		String source = "abc";

		// when
		char c = source.charAt(1);

		// then
		assertThat(c).isEqualTo('b');
	}

	@Test
	@DisplayName("charAt() 메소드의 인자로 문자열에 벗어나는 위치를 넣으면 예외가 발생해야 한다.")
	public void charAtExceptionTest() {
		// given
		String source = "abc";

		// when then
		assertThatThrownBy(() -> source.charAt(4))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessage("String index out of range: 4");
	}

}
