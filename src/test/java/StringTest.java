import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

	@Test
	public void splitTest() {
		String givenString = "1,2";
		String[] splitString = givenString.split(",");
		assertThat(splitString).contains("1", "2");
	}

	@Test
	@DisplayName("문자열이 , 를 기준으로 split을 하고 문자열 배열에 1이 있어야 한다")
	public void splitTest2() {
		String givenString = "1";
		String[] splitString = givenString.split(",");
		assertThat(splitString).containsExactly("1");
	}

	@Test
	public void substringTest() {
		String givenString = "(1,2)";
		String actual = givenString.substring(1, 4);
		assertThat(actual).isEqualTo("1,2");
	}

	@Test
	@DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
	public void charAtTest() {
		String givenString = "abc";
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
				.isThrownBy(() -> givenString.charAt(5));
	}
}
