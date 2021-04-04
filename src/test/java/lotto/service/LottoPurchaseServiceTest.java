package lotto.service;

import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoPurchaseServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 999})
    @DisplayName("최소금액 검증")
    void purchaseAmount(int purchaseAmount) {
        // given
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPurchaseService.purchaseLottoTickets(purchaseAmount, null))
                .withMessageMatching("최소 1000원 이상의 금액을 입력해 주세요.");
    }

    @Test
    @DisplayName("수동로또 구입정보 미입력")
    void manualLottoPurchaseNumberList_null() {
        // given
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPurchaseService.purchaseLottoTickets(5000, null))
                .withMessageMatching("수동로또 구매정보가 입력되지 않았습니다. 입력값을 확인해 주세요.");
    }

    @Test
    @DisplayName("구입금액 부족")
    void lackOfPurchaseAmount() {
        // given
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        List<String> manualLottoPurchaseNumberList = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7", "3, 4, 5, 6, 7, 8");

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPurchaseService.purchaseLottoTickets(2000, manualLottoPurchaseNumberList))
                .withMessageMatching("구입금액이 부족합니다. 금액과 구매장수를 확인해 주세요.");
    }

    @Test
    @DisplayName("로또티켓 구매장수 검증")
    void lottoTickets_count() {
        // given
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        List<String> manualLottoPurchaseNumberList = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7", "3, 4, 5, 6, 7, 8");

        // when
        LottoTickets lottoTickets = lottoPurchaseService.purchaseLottoTickets(7000, manualLottoPurchaseNumberList);

        // then
        assertThat(4).isEqualTo(lottoTickets.calculateAutoLottoCount());
        assertThat(3).isEqualTo(lottoTickets.calculateManualLottoCount());
        assertThat(7).isEqualTo(lottoTickets.getLottoList().size());
    }
}