package lottery;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	void create() {
		Money sut = Money.won(10000L);
		assertThat(sut).isEqualTo(Money.won(10000L));
		assertThatThrownBy(() -> Money.won(-1L))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("유효하지 않는 금액입니다");
	}

	@Test
	void minus() {
		Money _10000Won = Money.won(10000L);
		Money _5000Won = Money.won(5000L);

		Money result_5000Won = Money.won(5000L);

		assertThat(_10000Won.minus(_5000Won)).isEqualTo(result_5000Won);
	}

	@Test
	void divide() {
		Money _10000Won = Money.won(10000L);
		Money _5000Won = Money.won(5000L);

		int expected = 2;
		assertThat(_10000Won.divide(_5000Won)).isEqualTo(expected);
	}

	@Test
	void multiply() {
		Money _10000Won = Money.won(10000L);
		Money _5000Won = Money.won(5000L);
		int value = 2;

		assertThat(_5000Won.multiply(value)).isEqualTo(_10000Won);
	}

	@Test
	void divideWithFloating() {
		Money _10000Won = Money.won(10000L);
		Money _1000Wan = Money.won(1000L);

		long expected = 10L;
		assertThat(_10000Won.divideWithFloating(_1000Wan)).isEqualTo(expected);
	}
}
