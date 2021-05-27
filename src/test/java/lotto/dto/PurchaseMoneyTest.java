package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("PurchaseMoneyTest 테스트")
class PurchaseMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 300})
    @DisplayName("new_정상")
    void new_정상(int value) {

        // When, Then
        assertDoesNotThrow(() -> new PurchaseMoney(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-5", "abc", "!@", "re"})
    @DisplayName("new_예외_케이스1")
    void new_예외_케이스1(String value) {

        // When, Then
        // When, Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PurchaseMoney(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, -3, -1})
    @DisplayName("new_예외_케이스2")
    void new_예외_케이스2(int value) {

        // When, Then
        // When, Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PurchaseMoney(value));
    }
}
