package lotto.domain;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPurchaseTest {

    @ParameterizedTest
    @CsvSource(value = {
        "10000,0,10000,1.00",
        "10000,0,20000,2.00",
        "10000,0,15000,1.50",
        "10031,31,25000,2.50",
        "10031,31,30000,3.00",
        "10031,31,33333,3.33",
        "10031,31,35555,3.56",
    })
    void ROI는_두번째_자리수에서_반올림_된다(int invest, int change, int totalPrize, String expected) {
        LottoPurchase lottoPurchase
            = new LottoPurchase(new Money(invest), new Money(change), Collections.emptyList(), 0);

        BigDecimal roi = lottoPurchase.getRoi(new Money(totalPrize));

        assertThat(roi.toString()).isEqualTo(expected);
    }

}
