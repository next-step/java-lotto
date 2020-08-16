package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

	@DisplayName(value = "기본 구분자를 기준으로 문자열을 분리하는 기능 테스트")
	@Test
	void separateStringByDelimiter() {
		String[] result = StringUtils.split("1,2,3:4");
		assertThat(result).hasSize(4);
		assertThat(result).isEqualTo(new String[] {"1","2","3","4"});
	}

}
