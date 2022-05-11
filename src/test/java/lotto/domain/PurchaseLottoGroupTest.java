package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseLottoGroupTest {

	@DisplayName("구매수량만큼 로또 생성")
	@ValueSource(ints = {14, 100})
	@ParameterizedTest
	public void When_GivenPurchaseQuantity_Expected_matchingSizeLotto(int quantity) {
		PurchaseLottoGroup purchaseLottoGroup = new PurchaseLottoGroup(quantity);

		assertThat(purchaseLottoGroup.size()).isEqualTo(quantity);
	}
}
