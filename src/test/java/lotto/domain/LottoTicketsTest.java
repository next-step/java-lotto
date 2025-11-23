package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


//- [ ] 구입 금액을 1000으로 나눈 갯수반큼 로또 티켓을 발행한다.
//        - [ ] 1부터 45까지의 숫자 중 중복되지 않는 6개의 숫자를 무작위로 선택한다

public class LottoTicketsTest {
    @Test
    void 구입_금액으로_로또_티켓_생성() {
        PurchaseAmount purchaseAmount =new PurchaseAmount(5_000);

        LottoTickets tickets = LottoTickets.create(purchaseAmount);

        assertThat(tickets.size()).isEqualTo(5);
    }

    @Test
    void 모든_로또_티켓_조회() {
        PurchaseAmount purchaseAmount =new PurchaseAmount(3_000);

        LottoTickets tickets = LottoTickets.create(purchaseAmount);

        List<Lotto> lottos = tickets.getLottos();
        assertThat(lottos).hasSize(3);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }

    @Test
    void 구매금액과_수동로또개수가_같은경우_수동로또만_구매() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);
        Lotto manual1 = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto manual2 = new Lotto(7, 8, 9, 10, 11, 12);
        ManualLottos manualLottos = new ManualLottos(Arrays.asList(manual1, manual2));

        LottoTickets tickets = LottoTickets.create(purchaseAmount, manualLottos);

        assertThat(tickets.size()).isEqualTo(2);
        assertThat(tickets.getManualCount()).isEqualTo(2);
        assertThat(tickets.getAutoCount()).isEqualTo(0);
    }

    @Test
    void 수동_자동_혼합_구매() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);
        Lotto manual1 = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto manual2 = new Lotto(7, 8, 9, 10, 11, 12);
        ManualLottos manualLottos = new ManualLottos(Arrays.asList(manual1, manual2));

        LottoTickets tickets = LottoTickets.create(purchaseAmount, manualLottos);

        assertThat(tickets.size()).isEqualTo(5);
        assertThat(tickets.getManualCount()).isEqualTo(2);
        assertThat(tickets.getAutoCount()).isEqualTo(3);
    }

    @Test
    void 수동로또_개수가_구입가능_개수보다_많으면_예외를던진() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(2000);
        Lotto manual1 = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto manual2 = new Lotto(7, 8, 9, 10, 11, 12);
        Lotto manual3 = new Lotto(13, 14, 15, 16, 17, 18);
        ManualLottos manualLottos = new ManualLottos(Arrays.asList(manual1, manual2, manual3));

        assertThatThrownBy(() -> LottoTickets.create(purchaseAmount, manualLottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수동로또 개수가 구입 가능한 개수보다 많습니다.");
    }
}
