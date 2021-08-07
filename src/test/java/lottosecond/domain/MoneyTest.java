package lottosecond.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

	@Test
	@DisplayName("객체 생성")
	void create() throws Exception {
		//given
		String moneyText = "1000";

		//when
		Money money = new Money(moneyText);

		//then
		assertThat(money).isEqualTo(new Money(moneyText));

	}

	@ParameterizedTest(name = "로또 구입하지 못하는 금액 입력 {index} [{arguments}]")
	@ValueSource(ints = {
			-1, 0, 900
	})
	@DisplayName("로또 구입하지 못하는 금액 입력")
	void invalid_exception(int amount) throws Exception {
		//given

		//when
		ThrowableAssert.ThrowingCallable callable = () -> new Money(amount);

		//then
		assertThatThrownBy(callable).isInstanceOf(MoneySizeException.class)
		                            .hasMessage("로또 구입을 위해 1,000원 이상 필요합니다.");

	}


	@ParameterizedTest(name = "금액별 로또 수량 {index} [{arguments}]")
	@CsvSource(value = {
			"14000,14",
			"1000,1",
			"1500,1"
	})
	void lotto_count_by_money(int amount, int count) throws Exception {
		//given
		Money money = new Money(amount);

		//when
		int lottoCount = money.getLottoCount();

		//then
		assertThat(lottoCount).isEqualTo(count);

	}

}
