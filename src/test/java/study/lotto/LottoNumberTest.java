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
        LottoNumber lottoNumber = new LottoNumber(source);

        // When & Then
        assertEquals(lottoNumber, new LottoNumber(source));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1", "46"}, delimiter = ',')
    void test_create_fail(int source) {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(source));
    }

    @Test
    void test_equals() {
        // Given
        LottoNumber firstNumber = new LottoNumber(1);
        LottoNumber secondNumber = new LottoNumber(1);

        // When
        boolean equals = firstNumber.equals(secondNumber);

        // Then
        assertTrue(equals);
    }

    @Test
    void test_compareTo() {
        // Given
        LottoNumber one = new LottoNumber(1);
        LottoNumber two = new LottoNumber(2);

        // When
        int compareTo = one.compareTo(two);

        // Then
        assertEquals(compareTo, -1);
    }

}