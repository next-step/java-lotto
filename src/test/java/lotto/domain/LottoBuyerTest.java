package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBuyerTest {
    @Test
    @DisplayName("로또 자동 구매 수 테스트")
    void getAutoLottoCount() {
        LottoBuyer lottoBuyer = new LottoBuyer(15000, Arrays.asList("1,2,3,4,5,6"));

        int autoLottoCount = lottoBuyer.getAutoLottoCount();

        assertThat(autoLottoCount).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 수동 구매 수 테스트")
    void getManualLottoCount() {
        LottoBuyer lottoBuyer = new LottoBuyer(15000, Arrays.asList("1,2,3,4,5,6"));

        int manualLottoCount = lottoBuyer.getManualLottoCount();

        assertThat(manualLottoCount).isEqualTo(1);
    }
}