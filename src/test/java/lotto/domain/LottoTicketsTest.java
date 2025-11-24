package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottoTicketsTest {
    @Test
    void 구입_금액으로_로또_티켓_생성() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(5_000);

        LottoTickets tickets = LottoTicketsFactory.create(purchaseAmount);

        assertThat(tickets.size()).isEqualTo(5);
    }

    @Test
    void 모든_로또_티켓_조회() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(3_000);

        LottoTickets tickets = LottoTicketsFactory.create(purchaseAmount);

        List<Lotto> lottos = tickets.getLottos();
        assertThat(lottos).hasSize(3);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }

    @Test
    void 구매금액과_수동로또개수가_같은경우_수동로또만_구매() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);
        ManualLottos manualLottos = new ManualLottos(Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"));

        LottoTickets tickets = LottoTicketsFactory.create(purchaseAmount, manualLottos);

        assertThat(tickets.size()).isEqualTo(2);
        assertThat(tickets.getManualCount()).isEqualTo(2);
        assertThat(tickets.getAutoCount()).isEqualTo(0);
    }

    @Test
    void 수동_자동_혼합_구매() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);
        ManualLottos manualLottos = new ManualLottos(Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"));

        LottoTickets tickets = LottoTicketsFactory.create(purchaseAmount, manualLottos);

        assertThat(tickets.size()).isEqualTo(5);
        assertThat(tickets.getManualCount()).isEqualTo(2);
        assertThat(tickets.getAutoCount()).isEqualTo(3);
    }

    @Test
    void 수동로또_개수가_구입가능_개수보다_많으면_예외를던진() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);
        ManualLottos manualLottos = new ManualLottos(Arrays.asList(
                "1, 2, 3, 4, 5, 6",
                "7, 8, 9, 10, 11, 12",
                "13, 14, 15, 16, 17, 18"));

        assertThatThrownBy(() -> LottoTicketsFactory.create(purchaseAmount, manualLottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수동로또 개수가 구입 가능한 개수보다 많습니다.");
    }
}
