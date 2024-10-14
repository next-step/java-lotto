package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottoTicketGeneratorTest {

    @Test
    @DisplayName("createTicket 메서드에 구매 금액과 자동 로또 티켓이 주어졌을 때 나머지 금액만큼의 자동 복권을 포함한 LottoTicket을 반환한다.")
    void createTicketTest() {
        LottoPurchasePrice purchasePrice = LottoPurchasePrice.valueOf(3000);
        LottoTicket manualLottoTicket = new LottoTicket(
                List.of(new Lotto(Set.of(LottoNumber.valueOf(1),
                        LottoNumber.valueOf(2),
                        LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4),
                        LottoNumber.valueOf(5),
                        LottoNumber.valueOf(6)))
                )
        );
        LottoTicket lottoTicket = LottoTicketGenerator.createTicket(purchasePrice, manualLottoTicket);
        assertThat(lottoTicket.getTicket()).hasSize(3);
    }
}