import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringParserTest {
	@Test
	@DisplayName("빈 문자열 또는 null 값을 입력할 경우 0만 포함하는 리스트를 반환해야 한다.")
	void emptyStingReturnZeroTest() {
		assertThat(StringParser.parse(null)).isEqualTo(Collections.singletonList(0));
		assertThat(StringParser.parse("")).isEqualTo(Collections.singletonList(0));
	}

	@Test
	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자만 포함하는 리스트를 반환한다.")
	void onlyOneNumberStingReturnThatNumberTest() {
		assertThat(StringParser.parse("3")).isEqualTo(Collections.singletonList(3));
	}

	@Test
	@DisplayName("컴마(,) 구분자로 입력할 경우 ,로 구분된 숫자의 리스트를 반환한다.")
	void splitCommaTest() {
		assertThat(StringParser.parse("1,2,3")).isEqualTo(Arrays.asList(1,2,3));
	}

	@Test
	@DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
	void canSplitCommaOrColonTest() {
		assertThat(StringParser.parse("1:2:3:4")).isEqualTo(Arrays.asList(1,2,3,4));
	}

	@Test
	@DisplayName("“//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
	void canSplitCustomDelimiterTest() {
		assertThat(StringParser.parse("//;\n1;2;3")).isEqualTo(Arrays.asList(1,2,3));
	}

	@Test
	@DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
	void throwRuntimeExceptionWhenNegativeNumberTest() {
		assertThatThrownBy(() -> StringParser.parse("//;\n-1;2;3")).isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("숫자가 아닌 값을 전달할 경우 RuntimeException 예외가 발생해야 한다.")
	void throwRuntimeExceptionWhenNotNumberTest() {
		assertThatThrownBy(() -> StringParser.parse("//;\n1;a;3")).isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> StringParser.parse("//;\n1;2;?")).isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> StringParser.parse("bff")).isInstanceOf(RuntimeException.class);
	}
}
