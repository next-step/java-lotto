package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	@DisplayName("요구사항 1 : 1,2을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인")
	public void string_that_has_two_elements_split_test() {
		String[] splitArray = "1,2".split(",");

		assertThat(splitArray).containsExactly("1", "2");
	}

	@Test
	@DisplayName("요구사항 1 : 1을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
	public void string_that_has_one_element_split_test() {
		String[] splitedArray = "1".split(",");

		assertThat(splitedArray).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항 2 : (1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환하는지 확인")
	public void substring_string_test() {
		String substringString = "(1,2)".substring(1, 4);

		assertThat(substringString).isEqualTo("1,2");
	}

	@Test
	@DisplayName("요구사항 3 : abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인")
	public void chatAt_string_test() {
		String plainString = "abc";

		assertThat(plainString.charAt(2)).isEqualTo('c');
	}

	@Test
	@DisplayName("요구사항 3 : String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
	public void try_out_of_index_chatAt_string_and_get_error_test() {
		String plainString = "abc";

		assertThatThrownBy(() -> {
			plainString.charAt(3);
		}).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range");
	}
}
