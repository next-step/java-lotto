package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class LottoCountTest {

    @Test
    void create_inputvalidation_amount() {
        assertThatThrownBy(()->new LottoCount(1450)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_normal() {
        assertThat(new LottoCount(3000).getTotalLottoCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("구매 건수 조회")
    void getTotalLottoCount() {
        LottoCount lottoCount = new LottoCount(15000);
        assertThat(lottoCount.getTotalLottoCount()).isEqualTo(15);
        assertThat(lottoCount.getManualLottoCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("총 구매금액")
    void getTotalPaymentAmount() {
        LottoCount lottoCount = new LottoCount(15000);
        assertThat(lottoCount.getTotalPaymentAmount()).isEqualTo(new BigDecimal(15000));
    }

    @Test
    @DisplayName("수동건수 추가")
    void addManualLottoCount() {
        LottoCount lottoCount = new LottoCount(15000);
        lottoCount.addManualLottoCount(3);
        assertThat(lottoCount.getTotalLottoCount()).isEqualTo(15);
        assertThat(lottoCount.getManualLottoCount()).isEqualTo(3);
        assertThat(lottoCount.getAutoLottoCount()).isEqualTo(12);
    }
}
