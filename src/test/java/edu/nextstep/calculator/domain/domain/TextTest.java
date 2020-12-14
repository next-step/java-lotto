package edu.nextstep.calculator.domain.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import edu.nextstep.calculator.domain.Text;

@DisplayName("Text: 사용자가 입력한 문자열 포장한 클래스")
class TextTest {

	@DisplayName("생성자: 문자열을 받아 Text 객체를 정상적으로 생성하여 리턴함.")
	@Test
	public void generate() {
		Text text = new Text("1");
		assertThat(text)
			.isNotNull()
			.isInstanceOf(Text.class)
			.hasFieldOrPropertyWithValue("text", "1");
	}

	@DisplayName("isEmpty: Text 객체가 생성될 때 받은 문자열이 비어있거나 null이면 true를 리턴함. (문자열 레벨의 정합성 체크)")
	@ParameterizedTest
	@NullAndEmptySource
	public void isEmpty(String input) {
		assertThat(new Text(input).isEmpty()).isTrue();
	}

	@DisplayName("split: Text 객체의 원시 문자열을 기능요구사항에 따라 split해 리턴함. (isEmpty 체크는 하지 않음)")
	@Test
	void split() {
		assertThat(new Text("").split()).containsExactly("");
		assertThat(new Text("1").split()).containsExactly("1");
		assertThat(new Text("1,2").split()).containsExactly("1", "2");
		assertThat(new Text("1,2:3").split()).containsExactly("1", "2", "3");
		assertThat(new Text("//;\n1;2;3").split()).containsExactly("1", "2", "3");
		assertThat(new Text("-1,2,3").split()).containsExactly("-1", "2", "3");
	}
}