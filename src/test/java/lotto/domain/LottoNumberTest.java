package lotto.domain;

import calculator.domain.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 번호 테스트")
class LottoNumberTest {

    @ParameterizedTest
    @MethodSource("provideSource_new_정상")
    @DisplayName("new_정상")
    void new_정상(int value) {
        // When, Then
        assertDoesNotThrow(() -> new LottoNumber(value));
    }

    static Stream<Arguments> provideSource_new_정상() {
        List<Arguments> argumentsList = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            argumentsList.add(Arguments.of(i));
        }

        return argumentsList.stream();
    }

    @ParameterizedTest
    @MethodSource("provideSource_new_예외")
    @DisplayName("new_예외")
    void new_예외(int value) {
        // When, Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(value));
    }

    static Stream<Arguments> provideSource_new_예외() {
        List<Arguments> argumentsList = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER - 6; i <= MIN_LOTTO_NUMBER - 1; i++) {
            argumentsList.add(Arguments.of(i));
        }

        for (int i = MAX_LOTTO_NUMBER + 1; i <= MAX_LOTTO_NUMBER + 5; i++) {
            argumentsList.add(Arguments.of(i));
        }

        return argumentsList.stream();
    }

    @ParameterizedTest
    @MethodSource("provideSource_equals")
    @DisplayName("equals_true")
    void equals_true(int value) {
        // Given
        LottoNumber firstLottoNumber = new LottoNumber(value);
        LottoNumber secondLottoNumber = new LottoNumber(value);

        // When, Then
        assertTrue(firstLottoNumber.equals(secondLottoNumber));
    }

    @ParameterizedTest
    @MethodSource("provideSource_equals")
    @DisplayName("equals_false")
    void equals_false(int value) {
        // Given
        LottoNumber firstLottoNumber = new LottoNumber(value - 1);
        LottoNumber secondLottoNumber = new LottoNumber(value);

        // When, Then
        assertFalse(firstLottoNumber.equals(secondLottoNumber));
    }

    static Stream<Arguments> provideSource_equals() {
        List<Arguments> argumentsList = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER + 1; i <= MAX_LOTTO_NUMBER; i++) {
            argumentsList.add(Arguments.of(i, true));
        }

        return argumentsList.stream();
    }
}