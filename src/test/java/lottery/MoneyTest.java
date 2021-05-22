package lottery;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {

	Money sut;

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
		Long userInputMoney = 10000L;
		Long _5000 = 5000L;

		sut = Money.won(userInputMoney);
		sut = Money.won(userInputMoney);

		Money rest = sut.minus(Money.won(_5000));

		assertThat(rest).isEqualTo(Money.won(_5000));
	}
}