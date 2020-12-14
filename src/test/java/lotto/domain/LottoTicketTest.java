package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

	@DisplayName("총 구매 가격에서 수동, 자동 개수를 분리하는 테스트")
	@Test
	void 구매가능_개수_테스트() {
		LottoPrice lottoPrice = new LottoPrice("3000", "1");
		assertThat(lottoPrice.getAutoCount()).isEqualTo(2);
		assertThat(lottoPrice.getManualCount()).isEqualTo(1);
	}

	@DisplayName("자동, 수동 설정 가격으로 로또티켓을 생성 하는 테스트")
	@Test
	void 자동_수동_분할_로또티켓_생성_테스트() {
		LottoPrice lottoPrice = new LottoPrice("3000", "1");
		PurchaseTicket purchaseTicket = new PurchaseTicket(lottoPrice);
		purchaseTicket.manual("8, 21, 23, 41, 42, 43");
		assertThat(LottoTicket.ofPurchase(purchaseTicket).getLottoNumbers().size()).isEqualTo(3);
		assertThat(LottoTicket.ofPurchase(purchaseTicket).getLottoNumbers().size()).isEqualTo(3);
	}

	@DisplayName("수동 구매 가격보다 많이 구매한다면 에러를 발생시킨다.")
	@Test
	void 구매_가격_초과__테스트() {
		assertThatThrownBy(() -> {
			PurchaseTicket purchaseTicket = new PurchaseTicket(new LottoPrice("3000", "2"));
			purchaseTicket.manual("8, 21, 23, 41, 42, 43");
			purchaseTicket.manual("3, 5, 11, 16, 32, 38");
			purchaseTicket.manual("7, 11, 16, 35, 36, 44");
		}).isInstanceOf(IllegalArgumentException.class).hasMessage("구매 가격을 초과하였습니다.");
	}
}
