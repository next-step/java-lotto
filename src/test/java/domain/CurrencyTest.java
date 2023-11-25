package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CurrencyTest {
    @Test
    @DisplayName("kor을 입력하는 경우 해당 통화의 단위가 출력된다")
    void currencyTypeTest() {
        Currency krw = Currency.KRW;
        assertThat(krw.getCurrencyType()).isEqualTo("원");
    }

    @Test
    @DisplayName("kor을 입력하는 경우 해당 국가의 수익률을 계산한다.")
    void currencyRateTest() {
        Currency krw = Currency.KRW;
        float result = krw.calculate(100, 5);
        assertThat(result).isEqualTo(20);
    }
}
