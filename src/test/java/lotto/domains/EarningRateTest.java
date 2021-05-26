package lotto.domains;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.enums.Prize;

public class EarningRateTest {

    @DisplayName("수익률을 계산한다. 소수점 2자리 아래 버림")
    @ParameterizedTest(name = "총 당첨금: 0, 구매 금액: \"{1}\", 수익률: \"{1}\"")
    @CsvSource(value = {"1000,0.00"})
    void calculate_1(String payment, String rate) {
        Scores scores = new Scores();
        Purchase purchase = new Purchase(payment);

        EarningRate earningRate = new EarningRate(scores, purchase);

        assertThat(earningRate.toString()).isEqualTo(rate);
    }

    @DisplayName("수익률을 계산한다. 소수점 2자리 아래 버림")
    @ParameterizedTest(name = "총 당첨금: 2000000000, 구매 금액: \"{1}\", 수익률: \"{1}\"")
    @CsvSource(value = {"1000,2000000.00"})
    void calculate_2(String payment, String rate) {
        Scores scores = new Scores();
        scores.increase(Prize.SIX);
        Purchase purchase = new Purchase(payment);

        EarningRate earningRate = new EarningRate(scores, purchase);

        assertThat(earningRate.toString()).isEqualTo(rate);
    }

    @DisplayName("수익률을 계산한다. 소수점 2자리 아래 버림")
    @ParameterizedTest(name = "총 당첨금: 5000, 구매 금액: \"{1}\", 수익률: \"{1}\"")
    @CsvSource(value = {"14000,0.35"})
    void calculate_3(String payment, String rate) {
        Scores scores = new Scores();
        scores.increase(Prize.THREE);
        Purchase purchase = new Purchase(payment);

        EarningRate earningRate = new EarningRate(scores, purchase);

        assertThat(earningRate.toString()).isEqualTo(rate);
    }
}
