package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
	@Test
	@DisplayName("input string -> list 변환 테스트")
	void inputStringToList() {
		//given
		String input = "9,12,24,37, 39, 40";
		//when
		List<Integer> integers = InputView.convertedStringToIntegerList(input);
		//then
		assertThat(integers).isEqualTo(Arrays.asList(9, 12, 24, 37, 39, 40));
	}
}