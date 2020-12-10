package lotto.domain.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    private final Validator validator = new LottoValidator();

    @Test
    @DisplayName("유효한 값 입력 시 유효성 검사 성공 확인")
    public void validValueTest() {
        ValidatorUtils.assertDoesNotThrow(validator, "1,2,3,4,5,6");
    }

    @Test
    @DisplayName("숫자 혹은 콤마가 아닌 문자열을 입력 시 IllegalArgumentException 발생 테스트")
    public void inputNotNumericOrCommaStringTest() {
        ValidatorUtils.assertValidation(validator, "숫자 혹은 콤마가 아닙니다",
                LottoValidator.NOT_NUMBER_OR_COMMA_MESSAGE);
    }

    @Test
    @DisplayName("정해진 사이즈보다 큰 문자열을 입력 시 IllegalArgumentException 발생 테스트")
    public void outOfBoundTest() {
        ValidatorUtils.assertValidation(validator, "1,2,3,4,5,6,7",
                LottoValidator.SIZE_NOT_MATCH);
    }

    @Test
    @DisplayName("중복된 숫자 입력 시 IllegalArgumentException 발생 테스트")
    public void checkDuplicateNumber_duplicateNumbers_ExceptionThrown() {
        ValidatorUtils.assertValidation(validator, "1,2,3,4,4,5",
                String.format(LottoValidator.HAS_DUPLICATE_NUMBER, "4"));
    }
}