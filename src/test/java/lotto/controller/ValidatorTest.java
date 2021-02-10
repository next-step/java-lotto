package lotto.controller;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ValidatorTest {

    @DisplayName("사용자가 입력한 보너스 넘버 테스트")
    @ParameterizedTest
    @MethodSource("provideValidateBonusNumberTest")
    public void validateBonusNumberTest(String bonusNumber, boolean expected) {
        assertEquals(expected, Validator.validateBonusNumber(bonusNumber));
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
