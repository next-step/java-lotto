package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exception.IllegalLottoNumberException;

import static org.junit.jupiter.api.Assertions.*;


class LottoNumberTest {


    @DisplayName("로또번호 숫자 허용범위 내 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void lottoNumberRangeTest(int number) {
        assertDoesNotThrow(() -> LottoNumber.valueOf(number));
    }

    @DisplayName("로또번호 숫자 허용범위 내 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 52, 53, 54, 55, 46, 47, 48, 49})
    void lottoNumberOverRangeTest(int number) {
        assertThrows(IllegalLottoNumberException.class, () -> LottoNumber.valueOf(number));
    }

    @DisplayName("로또번호 캐시 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void cacheTest(int number) {
        LottoNumber lottoNumber = LottoNumber.valueOf(number);
        LottoNumber expectedNumber = LottoNumber.valueOf(number);

        assertEquals(lottoNumber,expectedNumber);
    }
}