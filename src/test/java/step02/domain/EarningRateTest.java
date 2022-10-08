package step02.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.BDDAssertions.then;

class EarningRateTest {

    @ParameterizedTest
    @CsvSource({
        "1000, 1000, 1.0F",
        "300, 1236, 0.24271844F",
        "10000, 123, 81.30081F",
    })
    void earningRate(int totalAmount, int purchasePrice, float earningRate) {
        then(new EarningRate(totalAmount, purchasePrice)).isEqualTo(new EarningRate(earningRate));
    }
}