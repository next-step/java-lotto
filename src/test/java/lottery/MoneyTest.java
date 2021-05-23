package lottery;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {

	private Money sut;

	@Test
	void create() {
		Long userInputMoney = 10000L;

		sut = Money.won(userInputMoney);

		assertThat(sut).isEqualTo(Money.won(userInputMoney));

		assertThatThrownBy(() -> Money.won(-1L))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("유효하지 않는 금액입니다");
	}

	@Test
	void minus() {
		sut = Money.won(10000L);
		Money won = Money.won(5000L);

		Money rest = sut.minus(won);

		assertThat(rest).isEqualTo(won);
	}

	@Test
	void divide() {
		sut = Money.won(10000L);
		Money _50000won = Money.won(5000L);

		assertThat(sut.divide(_50000won)).isEqualTo(2);
	}
}
