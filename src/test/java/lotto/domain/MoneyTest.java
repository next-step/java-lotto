package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.collections.Money;

public class MoneyTest {

	@DisplayName("돈의 범위가 1000원 미만인 경우 오류를 뱉는다.")
	@CsvSource({"999", "-999", "0", "-1", "1"})
	@ParameterizedTest
	void 구매할_금액이_1000원_미만일_수_없다(int value) {
		assertThatThrownBy(
			() -> new Money(value)
		).isInstanceOf(RuntimeException.class)
			.hasMessage("money input is wrong.");
	}

	@DisplayName("구매한 로또의 개수를 정상적으로 계산한다.")
	@CsvSource({"1000, 1", "2500, 2", "3499, 3", "4999, 4", "10001, 10"})
	@ParameterizedTest
	void 구매한_로또개수를_정상적으로_리턴한다(int value, int amount) {
		assertThat(new Money(value).getNumberOfPurchasedLotto()).isEqualTo(amount);
	}
}
