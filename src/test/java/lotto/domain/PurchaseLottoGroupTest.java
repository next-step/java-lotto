package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseLottoGroupTest {
	public static PurchaseLottoGroup GROUP1 = new PurchaseLottoGroup(List.of(
		"16, 3, 19, 21, 38, 39",
		"33, 19, 22, 7, 45, 30",
		"16, 1, 20, 39, 27, 14",
		"3, 5, 6, 24, 10, 31",
		"32, 22, 24, 44, 45, 14"
	));

	@DisplayName("구매수량만큼 로또 생성")
	@ValueSource(ints = {14, 100})
	@ParameterizedTest
	public void When_GivenPurchaseQuantity_Expected_matchingSizeLotto(int quantity) {
		PurchaseLottoGroup purchaseLottoGroup = new PurchaseLottoGroup(quantity);

		assertThat(purchaseLottoGroup.size()).isEqualTo(quantity);
	}
}
