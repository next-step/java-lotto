package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @DisplayName("로또 구매 정보를 바탕으로 로또 티켓이 생성된다.")
    @Test
    void generateLottoTickets() {
        List<String> manualLottoTickets = Arrays.asList("1, 2, 3, 4, 6, 7", "1, 2, 3, 4, 5, 6");
        LottoPurchaseInformation purchaseInfo = LottoPurchaseInformation.of(14500, manualLottoTickets);
        LottoTickets lottoTickets = LottoMachine.generateLottoTickets(purchaseInfo);
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(14);

    }

}