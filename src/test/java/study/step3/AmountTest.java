package study.step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import study.step3.domain.Amount;

public class AmountTest {
    @ParameterizedTest(name = "유효성 테스트")
    @ValueSource(strings = {"900", "-1"})
    public void valid(int input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Amount(input));
    }

    @ParameterizedTest(name = "복권 구매 갯수 테스트")
    @CsvSource(value = {"1000:1", "2000:2", "150000: 150"}, delimiter = ':')
    public void purchaseLottoCount(int input, int expected) {
        Amount amount = new Amount(input);
        assertThat(amount.getPurchaseLottoCount()).isEqualTo(expected);
    }
}
