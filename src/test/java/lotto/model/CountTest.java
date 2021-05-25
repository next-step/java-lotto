package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

	@Test
	@DisplayName("구매 횟수는 음수가 될 수 없다.")
	public void validateTest() {
		assertThatThrownBy(() -> Count.of(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("크기 비교를 할 수 있다.")
	public void greaterThanTest() {
		assertAll(
			() -> assertThat(Count.of(3).greaterThan(Count.of(3))).isFalse(),
			() -> assertThat(Count.of(3).greaterThan(Count.of(2))).isTrue()
		);
	}

}