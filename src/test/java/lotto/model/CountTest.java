package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

	@Test
	@DisplayName("구매 횟수는 음수가 될 수 없다.")
	public void validateTest() {
		assertThatThrownBy(() -> Count.of(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}

}