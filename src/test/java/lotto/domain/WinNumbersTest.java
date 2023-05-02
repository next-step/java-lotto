package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinNumbersTest {

	@DisplayName("당첨 넘버 예외 케이스 - 크기")
	@Test
	void test1() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new WinNumbers("1, 2, 3, 4, 5"))
			.withMessage(WinNumbers.SIZE_EXCEPTION_TEXT);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new WinNumbers("1, 2, 3, 4, 5, 6, 7"))
			.withMessage(WinNumbers.SIZE_EXCEPTION_TEXT);
	}

	@DisplayName("당첨 넘버 예외 케이스 - 숫자 타입")
	@Test
	void test2() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new WinNumbers("1, 2, 3, 4, 5, a"))
			.withMessage(WinNumbers.TYPE_EXCEPTION_TEXT);
	}

	@DisplayName("당첨 넘버 예외 케이스 - 중복")
	@Test
	void test4() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new WinNumbers("1, 2, 3, 4, 5, 5"))
			.withMessage(WinNumbers.DUPLICATE_EXCEPTION_TEXT);
	}
}
