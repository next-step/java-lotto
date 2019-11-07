package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoAmountTest {
    @Test
    void create_amount_test() {
        LottoAmount amount = new LottoAmount(14000);
        assertThat(amount).isEqualTo(new LottoAmount(14000));
    }

    @Test
    void get_purchased_lotto_count() {
        LottoAmount amount = new LottoAmount(14000);
        assertThat(amount.getPurchasedLottoCount()).isEqualTo(14);
    }

    @Test
    void 로또_적은_금액으로_사보기() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoAmount amount = new LottoAmount(500);
        }).withMessageMatching("건네주신 금액으로는 로또를 살 수 없습니다.");
    }
}