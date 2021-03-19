package step2.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ShopResponseTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1100:1:0",
            "1500:1:0",
            "2600:2:0"}, delimiter = ':')
    @DisplayName("원금과 로또를 모두 환불한다고 가정했을 때의 돈이 같지 않으면 예외를 던진다")
    void shopResponseThrowsExceptionOnInvalidInput(int moneyAmount, int capacity, int change) {
        assertThrows(IllegalArgumentException.class, () -> new ShopResponse(moneyAmount, capacity, null, change));
    }
}
