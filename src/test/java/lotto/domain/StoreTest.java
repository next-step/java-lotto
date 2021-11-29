package lotto.domain;

import lotto.domain.value.OrderPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {

    @Test
    @DisplayName("상점에서 돈 입력했을 경우 돈의 양만큼 로또티켓 생성 테스트")
    void lottoCreateTest() {
        Store store = new Store();
        LottoTicket lottoTicket = store.purchaseTicket(new OrderPrice("3000"));

        assertThat(lottoTicket.getLotto().size()).isEqualTo(3);
    }

}
