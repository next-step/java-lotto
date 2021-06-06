package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
	@Test
	@DisplayName("생성")
	void create() {
		assertThat(new Money(1000)).isNotNull();
		assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1))
			.withMessage("금액은 음수가 될 수 없습니다.");
	}

	@Test
	@DisplayName("금액 곱하기")
	void multiply() {
		assertThat(new Money(1000).multiply(3)).isEqualTo(new Money(3000));
	}

	@Test
	@DisplayName("금액 더하기")
	void plus() {
		assertThat(new Money(1000).plus(new Money(1000))).isEqualTo(new Money(2000));
	}

	@Test
	@DisplayName("금액 나누기")
	void divide() {
		assertThat(new Money(3000).divide(new Money(1000))).isEqualTo(3.0);
	}

	@Test
	@DisplayName("금액 차감")
	void minus() {
		assertThat(new Money(3000).minus(new Money(1000))).isEqualTo(new Money(2000));
	}
}