package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Money {
    @ParameterizedTest
    @MethodSource("constructorMethodSource")
    @DisplayName("")
    void constructorMethod() {
        // given

        // when

        // then
    }

    static Stream<Arguments> constructorMethodSource() {
        return Stream.of(
                Arguments.of(),
                );
    }
}
