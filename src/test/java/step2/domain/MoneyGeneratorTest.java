package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyGeneratorTest {

    private MoneyGenerator moneyGenerator;

    @BeforeEach
    void setUp() {
        this.moneyGenerator = new MoneyGenerator();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, -1500, -2600})
    @DisplayName("음수의 돈을 입력하면 예외를 던진다")
    void moneyWithNegativeNumberThrowsException(int moneyAmount) {
        assertThrows(IllegalArgumentException.class, () -> moneyGenerator.generateMoney(moneyAmount));
    }
}
