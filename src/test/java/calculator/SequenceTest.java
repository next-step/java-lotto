package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SequenceTest {

    static Stream<Arguments> generateListOfString() {
        return Stream.of(
            Arguments.of(Arrays.asList("1", "2", "a")),
            Arguments.of(Arrays.asList("1","0.5"))
        );
    }
    
    @Test
    @DisplayName("음수가 포함되어 있으면 예외를 던진다.")
    void throwExceptionIfListOfStringContainsNegativeInteger() {
        List<String> strSequence = Arrays.asList("1", "-2", "3");

        assertThatThrownBy(() -> new Sequence(strSequence)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "숫자가 아닌 문자가 있으면 예외를 던진다.")
    @MethodSource("generateListOfString")
    void throwExceptionIfListOfStringContainsNotInteger(List<String> strSequence) {
        assertThatThrownBy(() -> new Sequence(strSequence)).isInstanceOf(RuntimeException.class);
    }

}
