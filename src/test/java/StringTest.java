import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

	@ParameterizedTest
	@ValueSource(strings = {"1,2"})
	@DisplayName(value = "split 함수가 주어진 문자열 기준으로 배열을 나누는지 검증한다")
	void split(String data) {
		String[] result = data.split(",");

		assertThat(result).contains("1");
		assertThat(result).contains("2");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	@DisplayName(value = "split 을 실행할 대상이 없는 경우 1개의 element 만 존재한다")
	void splitOneElement() {
		String[] result = "1".split(",");

		assertThat(result).contains("1");
		assertThat(result.length).isEqualTo(1);
	}


}
