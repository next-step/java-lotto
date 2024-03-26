package lotto.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoPurchaseInfoTest {

    @DisplayName("구매정보를 입력하고, 수기 구매 개수를 구할 수 있다.")
    @Test
    void getManualCount() {
        // given
        List<List<Integer>> manualLottoNumbers = List.of(
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 3, 4, 11, 12),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 35)
        );
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(18000, manualLottoNumbers);

        // then
        assertThat(lottoPurchaseInfo.countManual()).isEqualTo(5);
    }

    @DisplayName("구매정보를 입력하고, 자동 구매 개수를 구할 수 있다.")
    @Test
    void getAutoCount() {
        // given
        List<List<Integer>> manualLottoNumbers = List.of(
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 3, 4, 11, 12),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 35)
        );
        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(18000, manualLottoNumbers);

        // then
        assertThat(lottoPurchaseInfo.countAuto()).isEqualTo(13);
    }

    @DisplayName("구매 정보가 음수로 입력되면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenPurchasedPriceIsMinus() {
        // given
        List<List<Integer>> manualLottoNumbers = List.of(
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 3, 4, 11, 12),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 35)
        );

        // then
        assertThrows(
                IllegalArgumentException.class,
                () -> new LottoPurchaseInfo(-18000, manualLottoNumbers)
        );
    }
}
