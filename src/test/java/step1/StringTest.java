package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	
	@Test
	@DisplayName(value = "1,2가 정상적으로 분리된다.")
	public void splitWord() throws Exception {
		String word = "1,2";
		String[] result = word.split(",");
		assertThat(result).hasSize(2);
		assertThat(result).contains("1");
		assertThat(result).contains("2");
	}

	@Test
	@DisplayName("1만 포함하는 배열로 반환된다.")
	public void splitSingleWord() throws Exception {
		String word = "1,";
		String[] result = word.split(",");
		assertThat(result).containsExactly("1");
	}
}
