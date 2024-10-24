package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoBuyDetailsTest {

    @Test
    void create_inputvalidation_amount() {
        assertThatThrownBy(() -> new LottoBuyDetails(1450, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_normal() {
        assertThat(new LottoBuyDetails(3000).getTotalLottoCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("구매 건수 조회")
    void getTotalLottoCount() {
        LottoBuyDetails lottoBuyDetails = new LottoBuyDetails(15000);
        assertThat(lottoBuyDetails.getTotalLottoCount()).isEqualTo(15);
        assertThat(lottoBuyDetails.getManualLottoCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("총 구매금액")
    void getTotalPaymentAmount() {
        LottoBuyDetails lottoBuyDetails = new LottoBuyDetails(15000);
        assertThat(lottoBuyDetails.getTotalPaymentAmount()).isEqualTo(new BigDecimal(15000));
    }


    @Test
    @DisplayName("수동 구매 건수 검증")
    void getManualLottoCount_validation() {
        assertThatThrownBy(()->new LottoBuyDetails(1000, new ManualBuyDetails(2,
                Arrays.asList(new LottoNumbers(new int[]{1,2,3,4,5,6}),new LottoNumbers(new int[]{1,2,3,4,5,6})))))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("수동 구매 건수")
    void getManualLottoCount() {
        LottoBuyDetails lottoBuyDetails = new LottoBuyDetails(15000, new ManualBuyDetails(1,Arrays.asList(new LottoNumbers(new int[]{1,2,3,4,5,6}))));
        assertThat(lottoBuyDetails.getManualLottoCount()).isEqualTo(1);
        assertThat(lottoBuyDetails.getTotalLottoCount()).isEqualTo(15);
        assertThat(lottoBuyDetails.getAutoLottoCount()).isEqualTo(14);
    }

    @Test
    void isMix1() {
        LottoBuyDetails lottoBuyDetails = new LottoBuyDetails(3000, new ManualBuyDetails(1,Arrays.asList(new LottoNumbers(new int[]{1,2,3,4,5,6}))));
        assertThat(lottoBuyDetails.isMix()).isTrue();
    }
    @Test
    void isMix2() {
        LottoBuyDetails lottoBuyDetails = new LottoBuyDetails(3000);
        assertThat(lottoBuyDetails.isMix()).isFalse();
        assertThat(lottoBuyDetails.isAuto()).isTrue();
    }
}
