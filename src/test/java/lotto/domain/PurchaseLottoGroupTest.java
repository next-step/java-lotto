package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseLottoGroupTest {

	@DisplayName("구매수량만큼 로또 생성")
	@Test
	public void When_CreatedPurchaseLottoGroup_Expected_SameSize() {
		PurchaseLottoGroup purchaseLottoGroup = PurchaseLottoGroup.create(List.of(
			LottoTest.MANUAL_LOTTO_1,
			LottoTest.MANUAL_LOTTO_2,
			LottoTest.MANUAL_LOTTO_3
		), 5);

		assertThat(purchaseLottoGroup.size()).isEqualTo(8);
	}

	@DisplayName("구매수량만큼 로또 생성")
	@Test
	public void When_GivenManualIsNull_Expected_Exception() {
		assertThatThrownBy(() -> PurchaseLottoGroup.create(null, 5))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
