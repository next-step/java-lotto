package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

	@Test
	@DisplayName("입력한 당첨번호 문자열을 숫자형 리스트로 변환 테스트")
	void toNumbers() {
		String inputNumbers = "1,2,3,4,5,6";
		List<Integer> numbers = InputView.toNumbers(inputNumbers, InputView.INPUT_LOTTO_NUMBERS_DELIMITER);

		assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
	}

}
