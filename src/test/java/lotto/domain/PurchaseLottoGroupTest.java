package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseLottoGroupTest {

	@DisplayName("구매수량만큼 로또 생성")
	@Test
	public void When_CreatedPurchaseLottoGroup_Expected_SameSize() {
		PurchaseLottoGroup purchaseLottoGroup = PurchaseLottoGroup.create(List.of(
			LottoTest.MANUAL_LOTTO_1,
			LottoTest.MANUAL_LOTTO_2
		), List.of(
			LottoTest.MANUAL_LOTTO_3
		));

		assertThat(purchaseLottoGroup.size()).isEqualTo(3);
	}

	@DisplayName("수동 로또가 null 이면 IllegalArgumentException 발생")
	@Test
	public void When_GivenManualIsNull_Expected_Exception() {
		assertThatThrownBy(() -> PurchaseLottoGroup.create(null, List.of(LottoTest.MANUAL_LOTTO_1)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동 로또가 null 이면 IllegalArgumentException 발생")
	@Test
	public void When_GivenAutoIsNull_Expected_Exception() {
		assertThatThrownBy(() -> PurchaseLottoGroup.create(List.of(LottoTest.MANUAL_LOTTO_1), null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("구매한 모든 로또가 0개이면 IllegalArgumentException 발생")
	@Test
	public void When_EmptyLotto_Expected_Exception() {
		assertThatThrownBy(() -> PurchaseLottoGroup.create(Collections.emptyList(), Collections.emptyList()))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
