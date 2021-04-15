package step2.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exceptions.DuplicationLottoNumbers;
import step2.exceptions.OutOfLottoNumberRange;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @Test
    @DisplayName("로또번호 범위 검증 테스트")
    void 로또번호_범위_검증테스트() {
        // given
        List<Integer> numbers = Arrays.asList(46,2,3,4,5,6);

        // then
        assertThrows(OutOfLottoNumberRange.class, () -> {
            ValidationUtils.validationNumbers(numbers);
        });
    }

    @Test
    @DisplayName("중복숫자 검증 테스트")
    void 중복숫자테스트() {
        // given
        List<Integer> numbers = Arrays.asList(1,2,3,4,6,6);

        // then
        assertThrows(DuplicationLottoNumbers.class, () -> {
            ValidationUtils.validationNumbers(numbers);
        });
    }
}
