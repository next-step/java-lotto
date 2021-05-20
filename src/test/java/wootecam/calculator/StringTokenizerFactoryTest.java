package wootecam.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTokenizerFactoryTest {

	private StringTokenizerFactory tokenizerFactory;

	@BeforeEach
	void setup() {
		tokenizerFactory = StringTokenizerFactory.getInstance();
	}

	@ParameterizedTest
	@ValueSource(strings = {"//;\\n1;2;3", "//_\\n1_2_3"})
	@DisplayName("커스텀 문자열 분리를 위한 StringTokenizer 반환 확인")
	void getCustomStringTokenizerTest(String input) {
		StringTokenizer stringTokenizer = tokenizerFactory.getStringTokenizer(input);
		assertThat(stringTokenizer).isInstanceOf(CustomStringTokenizer.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3", "1:2:3"})
	@DisplayName("기본 문자열 분리를 위한 StringTokenizer 반환 확인")
	void getDefaultStringTokenizerTest(String input) {
		StringTokenizer stringTokenizer = tokenizerFactory.getStringTokenizer(input);
		assertThat(stringTokenizer).isInstanceOf(DefaultStringTokenizer.class);
	}

}