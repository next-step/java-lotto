package step3.model.amount;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.exception.BadRequestException;

class AmountTest {

	@DisplayName("구입 가능한 최소 금액보다 적을 경우 예외를 던진다.")
	@Test
	void Given_LessAmount_Then_ThrowException() {

		assertThatThrownBy(() -> new Amount(900, 1)).isInstanceOf(BadRequestException.class);
	}

	@DisplayName("구입 가능한 최소 금액 이상이면 에러를 던지지 않는다.")
	@Test
	void Given_MinAmount_Then_ThrowException() {

		assertDoesNotThrow(() -> new Amount(1200, 1));
	}

	@DisplayName("구입한 로또 개수는 구입 금액에서 1000을 나눈 값이다.")
	@Test
	void Given_Amount_Then_ReturnCount() {
		Amount amount = new Amount(1200, 1);

		assertThat(amount.getLottoCount()).isEqualTo(1);
	}

	@DisplayName("수동으로 구입 가능한 로또 개수는 구입한 로또 개수를 초과할 수 없다.")
	@Test
	void Given_OverManualCount_Then_ThrowException() {

		assertThatThrownBy(() -> new Amount(1000, 2)).isInstanceOf(BadRequestException.class);
	}
}