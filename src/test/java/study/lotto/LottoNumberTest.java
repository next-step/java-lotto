package study.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.core.LottoNumber;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "45"}, delimiter = ',')
    void test_create_success(int source) {
        // Given
        LottoNumber lottoNumber = LottoNumber.of(source);

        // When & Then
        assertEquals(lottoNumber, LottoNumber.of(source));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1", "46"}, delimiter = ',')
    void test_create_fail(int source) {
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(source));
    }

    @Test
    void test_equals() {
        // Given
        LottoNumber firstNumber = LottoNumber.of(1);
        LottoNumber secondNumber = LottoNumber.of(1);

        // When
        boolean equals = firstNumber.equals(secondNumber);

        // Then
        assertTrue(equals);
    }

    @Test
    void test_compareTo() {
        // Given
        LottoNumber one = LottoNumber.of(1);
        LottoNumber two = LottoNumber.of(2);

        // When
        int compareTo = one.compareTo(two);

        // Then
        assertEquals(compareTo, -1);
    }

}