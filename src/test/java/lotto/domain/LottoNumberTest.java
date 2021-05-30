package lotto.domain;

import lotto.exception.IllegalLottoNumberArgumentTypeException;
import lotto.exception.IllegalLottoNumberBoundaryException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.valueOf;
import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 번호 테스트")
class LottoNumberTest {

    @ParameterizedTest
    @MethodSource("provideSource_valueOf_정수_정상")
    @DisplayName("valueOf_정수_정상")
    void valueOf_정수_정상(int value) {
        // When, Then
        assertDoesNotThrow(() -> LottoNumber.valueOf(value));
    }

    static Stream<Arguments> provideSource_valueOf_정수_정상() {
        List<Arguments> argumentsList = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            argumentsList.add(Arguments.of(i));
        }

        return argumentsList.stream();
    }

    @ParameterizedTest
    @MethodSource("provideSource_valueOf_정상_문자열_타입_숫자")
    @DisplayName("valueOf_정상_문자열_타입_숫자")
    void valueOf_정상_문자열_타입_숫자(String value) {
        // When, Then
        assertDoesNotThrow(() -> LottoNumber.valueOf(value));
    }

    static Stream<Arguments> provideSource_valueOf_정상_문자열_타입_숫자() {
        List<Arguments> argumentsList = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            argumentsList.add(Arguments.of(String.valueOf(i)));
        }

        return argumentsList.stream();
    }

    @ParameterizedTest
    @MethodSource("provideSource_valueOf_예외_유효_범위_밖_숫자")
    @DisplayName("valueOf_예외_유효_범위_밖_숫자")
    void valueOf_예외_유효_범위_밖_숫자(int value) {
        // When, Then
        assertThatExceptionOfType(IllegalLottoNumberBoundaryException.class)
                .isThrownBy(() -> LottoNumber.valueOf(value));
    }

    static Stream<Arguments> provideSource_valueOf_예외_유효_범위_밖_숫자() {
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
    @ValueSource(strings = {"s", "b", "c", "d", "e", "!", "@", "#"})
    @DisplayName("valueOf_예외_숫자_형식이_아닌_문자열")
    void valueOf_예외_숫자_형식이_아닌_문자열(String value) {
        // When, Then
        assertThatExceptionOfType(IllegalLottoNumberArgumentTypeException.class)
                .isThrownBy(() -> LottoNumber.valueOf(value));
    }

    @ParameterizedTest
    @MethodSource("provideSource_equals")
    @DisplayName("equals_true")
    void equals_true(int value) {
        // Given
        LottoNumber firstLottoNumber = LottoNumber.valueOf(value);
        LottoNumber secondLottoNumber = LottoNumber.valueOf(value);

        // When, Then
        assertTrue(firstLottoNumber.equals(secondLottoNumber));
    }

    @ParameterizedTest
    @MethodSource("provideSource_equals")
    @DisplayName("equals_false")
    void equals_false(int value) {
        // Given
        LottoNumber firstLottoNumber = LottoNumber.valueOf(value - 1);
        LottoNumber secondLottoNumber = LottoNumber.valueOf(value);

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