package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("구입금액 테스트")
public class PuchaseAmountTest {

	@Test
	@DisplayName("구입금액이 최소금액 미만인 경우 예외발생")
	void createWrongPuchaseAmount() {
		Assertions.assertThatThrownBy(()->{
			PuchaseAmount puchaseAmount = new PuchaseAmount(999);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("구매금액으로 몇개의 로또를 구입할 수 있는지 테스트")
	void findNumberOfAvailablePurchases() {
		PuchaseAmount puchaseAmount = new PuchaseAmount(14000);
		int lottoCount = puchaseAmount.findNumberOfAvailablePurchases();
		assertThat(lottoCount).isEqualTo(14);
	}

}
