import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	String sut;
	@Test
	void splitTest() {

		sut = "1,2";
		String[] split = sut.split(",");

		assertThat(split).containsExactly("1", "2");
		assertThat(split.length).isEqualTo(2);

		sut = "1";
		String[] split1 = sut.split(",");
		assertThat(split1).containsExactly("1");
	}

	@Test
	void subStringTest() {
		sut = "(1,2)";
		String actual = sut.substring(1, sut.length() - 1);

		String expect = "1,2";
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	@DisplayName("charAt의 특정 범위를 넘을 경우 예외 호출")
	void charAtTest() {
		sut = "abc";

		assertThatThrownBy(() -> sut.charAt(5))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
