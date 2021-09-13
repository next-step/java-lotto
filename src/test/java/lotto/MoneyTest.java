package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	@DisplayName("돈은 0보다 작을 수 없습니다.")
	void noZeroMoney() {
		assertThatThrownBy(() -> {
			new Money(-1);
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("돈을 소모합니다.")
	void spendMoney() {
		Money money = new Money(1000);
		money.spend(new Money(100));
		assertThat(money).isEqualTo(new Money(900));

		assertThatThrownBy(() -> {
			money.spend(new Money(1000));
		});
	}

	@Test
	@DisplayName("돈을 비교")
	void compare() {
		assertThat(new Money(100).compareTo(new Money(200))).isLessThan(0);
		assertThat(new Money(100).compareTo(new Money(100))).isEqualTo(0);
		assertThat(new Money(200).compareTo(new Money(100))).isGreaterThan(0);
	}

	@Test
	@DisplayName("돈 합치기, 나누기")
	void calculate() {
		assertThat(new Money(100).add(new Money(200))).isEqualTo(new Money(300));
		assertThat(new Money(300).divide(new Money(100))).isEqualTo(new Money(3));
	}
}
