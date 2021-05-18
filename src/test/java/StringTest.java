import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {
	@Test
	@DisplayName("요구사항1 : split 테스트")
	void spilt() {
		assertThat("1,2".split(",")).containsExactly("1", "2");
		assertThat("1".split(",")).containsExactly("1");
	}
	@Test
	@DisplayName("요구사항2 : substring 테스트")
	void substring() {
		String input = "(1,2)";
		assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
	}

}
