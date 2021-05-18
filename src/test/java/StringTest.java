import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

	@Test
	public void splitTest() {
		String givenString = "1,2";
		String[] splitString = givenString.split(",");
		assertThat(splitString).contains("1", "2");
	}

	@Test
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
}
