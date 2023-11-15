package stringCalculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SplitterTest {

	@DisplayName("문자열 안에 공백을 다 없앤 뒤 문자열 배열로 만든다")
	@Test
	void removeBlank() {
		String input = "안 1 하 3";

		Splitter splitter = new Splitter();
		String[] removedString = splitter.removeBlank(input);

		assertThat(removedString.length).isEqualTo(4);
		assertThat(removedString).containsExactly("안", "1", "하", "3");
	}
}