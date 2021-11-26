package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.MoneyRangeNegativeException;
import step3.model.Money;

@DisplayName("Money 클래스 테스트")
public class MoneyTest {

    @DisplayName("예외 - 0 미만의 값으로 생성 불가")
    @ParameterizedTest(name = "[{index}] won = {0}")
    @ValueSource(longs = {Long.MIN_VALUE, -1})
    void exception_under0(long inputMoney) {
        assertThatThrownBy(() -> new Money(inputMoney))
            .isInstanceOf(MoneyRangeNegativeException.class);
    }

    @DisplayName("보유한 금액에 따른 구매 가능 여부 확인")
    @ParameterizedTest(name = "[{index}] won = {0} res = {1}")
    @CsvSource(value = {
        "999, false",
        "1000, true"
    })
    void canPurchase(long money, boolean canPurchase) {
        assertThat(new Money(money).canPurchase()).isEqualTo(canPurchase);
    }

    @DisplayName("보유한 금액에 따라 수익률을 낼 수 있는지 여부 확인")
    @ParameterizedTest(name = "[{index}] won = {0} res = {1}")
    @CsvSource(value = {
        "0, false",
        "1, true"
    })
    void isUnableToYield(long money, boolean ableToYield) {
        assertThat(new Money(money).ableToYield()).isEqualTo(ableToYield);
    }

    @DisplayName("돈의 합이 잘 계산되는지 여부 확인")
    @ParameterizedTest(name = "[{index}] original = {0}, other = {1}, result - {2}")
    @MethodSource("addArguments")
    void add(Money origin, Money operand, Money result) {
        origin.add(operand.won());
        assertEquals(result, origin);
    }

    private static Stream<Arguments> addArguments() {
        return Stream.of(
            Arguments.of(new Money(0), new Money(1), new Money(1)),
            Arguments.of(new Money(0), new Money(1000), new Money(1000))
        );
    }

    @DisplayName("로또 구매가 잘 되는지 여부 확인")
    @Test
    void purchase() {
        Money money = new Money(2000);
        money.purchase();
        assertEquals(money, new Money(1000));
    }
}
