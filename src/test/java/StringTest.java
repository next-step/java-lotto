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
}
