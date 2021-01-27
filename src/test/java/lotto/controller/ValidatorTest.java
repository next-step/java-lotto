package lotto.controller;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @DisplayName("정확한 로또 금액 테스트")
    @ParameterizedTest
    @MethodSource("providePriceValidatorTest")
    public void correctPriceValidatorTest(String input, boolean expected) {
        assertEquals(expected, validator.isPriceValidate(input));
    }

    private static Stream<Arguments> providePriceValidatorTest() {
        return Stream.of(
            Arguments.of("24000", true),
            Arguments.of("1000", true),
            Arguments.of("asdkfjasd", false),
            Arguments.of("24", false),
            Arguments.of("0000", false)
        );
    }

    @DisplayName("사용자가 입력한 당첨 번호 개수와 수가 올바른지 테스트")
    @ParameterizedTest
    @MethodSource("provideValidateWinningNumberTest")
    public void validateWinningNumberTest(String winningNumber, boolean expected) {
        System.out.println(winningNumber);
        assertEquals(expected, validator.validateWinningNumber(winningNumber));
    }

    private static Stream<Arguments> provideValidateWinningNumberTest() {
        return Stream.of(
            Arguments.of("1, 2, 3, 4, 5, 6", true),
            Arguments.of("1, 2, 3, 4, 5, 5", false),  // FAIL
            Arguments.of("1, 2, 3, 4, 5, 47", false),
            Arguments.of("1; 2, 3, 4; 5, 47", false),
            Arguments.of("1, 2, 3, 4, 5, 6, 8", false), // FAIL
            Arguments.of("123456", false),
            Arguments.of("asdfasdfasdf", false)
        );
    }

    @DisplayName("사용자가 입력한 보너스 넘버 테스트")
    @ParameterizedTest
    @MethodSource("provideValidateBonusNumberTest")
    public void validateBonusNumberTest(String bonusNumber, boolean expected) {
        assertEquals(expected, validator.validateBonusNumber(bonusNumber));
    }

    private static Stream<Arguments> provideValidateBonusNumberTest() {
        return Stream.of(
            Arguments.of("45", true),
            Arguments.of("0", false),
            Arguments.of("asd", false),
            Arguments.of("57", false),
            Arguments.of("00", false)
        );
    }

}
