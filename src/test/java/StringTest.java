import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

	@Test
	@DisplayName("String split method를 이용하여 문자열 자르기 테스트")
	void splitTest(){
		assertThat("1,2".split(","))
			.hasSize(2)
			.contains("1", "2");
	}

	@Test
	@DisplayName("String split method를 이용하여 하나의 문자만 가지는 문자열 자르기 테스트")
	void splitTestWithSingleText(){
		assertThat("1".split(","))
			.containsExactly("1");
	}

	@Test
	@DisplayName("String substring을 이용하여 첫번째 문자와 끝 문자 자르기 테스트")
	void substringTest(){
		String text = "(1,2)";
		assertThat(text.substring(1, text.length()-1))
			.isEqualTo("1,2");
	}

	
}
