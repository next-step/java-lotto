package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoAmountEnumTest {
    @Test
    void getUnitAmout() {
        assertThat(LottoAmountEnum.UNIT_AMOUNT.getValue()).isEqualTo(1000);
    }
    @Test
    void getThreeMatchingAmout() {
        assertThat(LottoAmountEnum.THREE_MATCHING_AMOUNT.getValue()).isEqualTo(5000);
    }

    @Test
    void getFourMatchingAmout() {
        assertThat(LottoAmountEnum.FOUR_MATCHING_AMOUNT.getValue()).isEqualTo(50000);
    }
    @Test
    void getFiveMatchingAmout() {
        assertThat(LottoAmountEnum.FIVE_MATCHING_AMOUNT.getValue()).isEqualTo(1500000);
    }
    @Test
    void getSixMatchingAmout() {
        assertThat(LottoAmountEnum.SIX_MATCHING_AMOUNT.getValue()).isEqualTo(2000000000);
    }
}
