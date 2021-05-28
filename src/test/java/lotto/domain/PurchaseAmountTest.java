package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("구입금액 테스트")
public class PurchaseAmountTest {

	@Test
	@DisplayName("구입금액이 최소금액 미만인 경우 예외발생")
	void createWrongPuchaseAmount() {
		Assertions.assertThatThrownBy(() -> {
			PurchaseAmount purchaseAmount = new PurchaseAmount(999);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("구매금액으로 몇개의 로또를 구입할 수 있는지 테스트")
	@CsvSource(value = {"1000:1", "2000:2", "3000:3", "4000:4", "5400:5", "5900:5", "6100:6"}, delimiter = ':')
	void findNumberOfAvailablePurchases(int money, int count) {
		PurchaseAmount purchaseAmount = new PurchaseAmount(money);
		int lottoCount = purchaseAmount.findNumberOfAvailablePurchases();
		assertThat(lottoCount).isEqualTo(count);
	}

}
