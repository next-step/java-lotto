package lotto.domain;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPurchaseTest {

    @ParameterizedTest
    @CsvSource(value = {
        "10031,10000,1.00",
        "10031,20000,2.00",
        "10031,15000,1.50",
        "10031,25000,2.50",
        "10031,30000,3.00",
        "10031,33333,3.33",
        "10031,35555,3.56",
    })
    void ROI는_두번째_자리수에서_반올림_된다(int invest, int totalPrize, String expected) {
        LottoPurchase lottoPurchase
            = new LottoPurchase(new Money(invest));

        BigDecimal roi = lottoPurchase.getRoi(new Money(totalPrize));

        assertThat(roi.toString()).isEqualTo(expected);
    }

}
