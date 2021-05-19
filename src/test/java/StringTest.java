import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @DisplayName("comma(,)를 사용한 split 테스트")
    @ParameterizedTest
    @MethodSource("provideSourceToSplitWithComma")
    void splitWithComma(String target, String[] expectedResult) {
        // Given
        String testingTarget = target;

        // When
        String[] splitTarget = testingTarget.split(",");

        // Then
        assertThat(splitTarget).containsExactly(expectedResult);
    }

    private static Stream<Arguments> provideSourceToSplitWithComma() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }
}
