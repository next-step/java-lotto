package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoManualServiceTest {

    @Test
    @DisplayName("수동로또 - 구매금액 부족")
    void purchaseAmount() {
        // given
        LottoManualService lottoManualService = new LottoManualService();
        int purchaseAmount = 2500;
        List<String> manualLottoPurchaseNumberList = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7", "4, 5, 6, 7, 8, 9");

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoManualService.purchaseLottoTicket(purchaseAmount, manualLottoPurchaseNumberList))
                .withMessageMatching("구입금액이 부족합니다. 금액과 구매장수를 확인해 주세요.");
    }
}