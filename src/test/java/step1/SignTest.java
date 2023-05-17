package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.CalculateStratety.Divide;
import step1.CalculateStratety.Minus;
import step1.CalculateStratety.Multi;
import step1.CalculateStratety.Plus;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static step1.Sign.*;
import static step1.Sign.DIVIDE;

class SignTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 사직연산_정규식(String sign) {
        assertThat(Sign.signRegexString()).contains(sign);
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "@", "!"})
    void 사직연산_정규식_X(String sign) {
        assertFalse(signRegexString().contains(sign));
    }
}