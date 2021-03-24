package study.step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step3.domain.Amount;

public class AmountTest {
	@Test
	@DisplayName("유효성 테스트")
	public void valid() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Amount(-1));
	}
}
