package lotto.domain.common;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 10/11/2018.
 */
public class MoneyTest {

	@Test
	public void test_MONEY생성() {
		Money money = Money.of(1000);
		BigDecimal actual = money.getAmount();
		BigDecimal expect = BigDecimal.valueOf(1000);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test_MONEY덧셈연산() {
		Money money1 = Money.of(1000);
		Money money2 = Money.of(1000);

		BigDecimal expect = BigDecimal.valueOf(2000);
		Money actual = money1.add(money2);

		assertThat(actual).isNotSameAs(money1);
		assertThat(actual).isNotSameAs(money2);
		assertThat(actual.getAmount()).isEqualTo(expect);
	}

	@Test
	public void test_MONEY덧셈연산_2() {
		Money money1 = Money.of(2000);
		Money money2 = Money.of(1000);

		BigDecimal expect = BigDecimal.valueOf(3000);
		Money actual = money1.add(money2);

		assertThat(actual).isNotSameAs(money1);
		assertThat(actual).isNotSameAs(money2);
		assertThat(actual.getAmount()).isEqualTo(expect);
	}

	@Test
	public void test_뺄셈연산() {
		Money money1 = Money.of(2000);
		Money money2 = Money.of(1000);

		BigDecimal expect = BigDecimal.valueOf(1000);
		Money actual = money1.subtract(money2);

		assertThat(actual).isNotSameAs(money1);
		assertThat(actual).isNotSameAs(money2);
		assertThat(actual.getAmount()).isEqualTo(expect);
	}

	@Test
	public void test_뺄셈연산_2() {
		Money money1 = Money.of(2000);
		Money money2 = Money.of(2000);

		BigDecimal expect = BigDecimal.ZERO;
		Money actual = money1.subtract(money2);

		assertThat(actual).isNotSameAs(money1);
		assertThat(actual).isNotSameAs(money2);
		assertThat(actual.getAmount()).isEqualTo(expect);
	}
}
