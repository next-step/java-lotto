package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyNumberTest {
    private BuyNumber buyNumber;
    int total = 10;
    int manual = 5;

    @BeforeEach
    void setUp() {
        buyNumber = new BuyNumber(total, manual);
    }

    @Test
    void createTest() {
        assertThat(buyNumber).isEqualTo(new BuyNumber(total, manual));
        assertThat(buyNumber.getTotalNumber()).isEqualTo(total);
        assertThat(buyNumber.getManualNumber()).isEqualTo(manual);
        assertThat(buyNumber.getAutoNumber()).isEqualTo(total-manual);

    }

    @Test
    void hasManualTest() {
        //given
        BuyNumber zeroManual = new BuyNumber(total, 0);

        //when, then
        assertThat(buyNumber.hasManual()).isTrue();
        assertThat(zeroManual.hasManual()).isFalse();
    }

}
