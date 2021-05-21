package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사용자 입력 서비스 테스트")
public class InputServiceTest {

	InputService inputService;

	@BeforeEach
	void setUp() {
		inputService = new InputService();
	}

	@Test
	@DisplayName("사용자가 입력한 금액 문자열이 유효한지 체크")
	void validationInputPurchaseAmount() {
		assertThat(inputService.validationInputPurchaseAmount("14000")).isTrue();

		assertThatIllegalArgumentException().isThrownBy(() -> {
			boolean result = inputService.validationInputPurchaseAmount("1400a");
		});
	}

	@Test
	@DisplayName("사용자가 입력한 금액 문자열이 유효하지 않을경우 재입력 여부 체크")
	void isContinuesInputPurchaseAmount() {
		assertThat(inputService.isContinuesInputPurchaseAmount("14000")).isFalse();
		assertThat(inputService.isContinuesInputPurchaseAmount("1400a")).isTrue();
	}

	@Test
	@DisplayName("입력값 숫자 여부 테스트")
	void isNumeric() {
		assertThat(InputService.isNumeric("1234")).isTrue();
		assertThat(InputService.isNumeric("123a")).isFalse();
	}

	@Test
	@DisplayName("입력한 당첨번호 문자열을 숫자형 리스트로 변환 테스트")
	void toNumbers() {
		String inputNumbers = "1,2,3,4,5,6";
		List<Integer> numbers = InputService.toNumbers(inputNumbers, InputService.INPUT_LOTTO_NUMBERS_DELIMITER);

		assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
	}

}
