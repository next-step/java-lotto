package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

	@DisplayName("")
	@Test
	void 자동_수동_분할_구매_테스트() {
		LottoPrice lottoPrice = new LottoPrice("2500", "0");
		PurchaseTicket purchaseTicket = new PurchaseTicket(lottoPrice);
		assertThat(LottoTicket.purchase(purchaseTicket).getLottoNumbers().size()).isEqualTo(2);
	}

	@DisplayName("")
	@Test
	void name2() {
		LottoPrice lottoPrice = new LottoPrice("3000", "1");
		assertThat(lottoPrice.availablePurchaseAutoAmount()).isEqualTo(2);
		assertThat(lottoPrice.getManualCount()).isEqualTo(1);
	}

	@DisplayName("수동 구매 가격보다 많이 구매한다면 에러를 발생시킨다.")
	@Test
	void name() {
		assertThatThrownBy(() -> {
			PurchaseTicket purchaseTicket = new PurchaseTicket(new LottoPrice("3000", "2"));
			purchaseTicket.manual(LottoNumberGenerator.ofInput("8, 21, 23, 41, 42, 43"));
			purchaseTicket.manual(LottoNumberGenerator.ofInput("3, 5, 11, 16, 32, 38"));
			purchaseTicket.manual(LottoNumberGenerator.ofInput("7, 11, 16, 35, 36, 44"));
		}).isInstanceOf(IllegalArgumentException.class).hasMessage("구매 가격을 초과하였습니다.");
	}
}
