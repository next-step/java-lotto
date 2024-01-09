package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class LottoTest {
	@Test
	@DisplayName("Lotto 파라미터로 Sting이 들어올 경우")
	void Lotto_String() {
		Lotto lotto = Lotto.of("1,2,3,4,5,6");
		for (int i = 1; i < 7; i++) {
			assertTrue(lotto.contains(LottoNumber.of(i)));
		}
	}

	@Test
	@DisplayName("Lotto 파라미터로 Integer로 들어올 경우")
	void Lotto_Integer() {
		Lotto lotto = Lotto.from(1, 2, 3, 4, 5, 6);
		for (int i = 1; i < 7; i++) {
			assertTrue(lotto.contains(LottoNumber.of(i)));
		}
	}

	@Test
	@DisplayName("로또 번호의 개수가 6개가 아닌 경우")
	void 로또_사이즈_6개_체크() {
		String expectingMessage = "숫자 6개만 입력해주세요";

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Lotto.of("1,2,3,4,5"))
			.withMessageMatching(expectingMessage);

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> Lotto.of("1,2,3,4,5,6,7"))
			.withMessageMatching(expectingMessage);
	}
}
