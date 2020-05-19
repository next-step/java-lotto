package splitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterManagerTest {

    private SplitterManager splitterManager;

    @BeforeEach
    void setUp() {
        splitterManager = SplitterManager.of();
    }

    @DisplayName(value = "커스텀 구분자에 매칭되는 문자열이면 CustomSplitter 를 반환")
    @ParameterizedTest
    @MethodSource("customSplitterCase")
    void customSplitter(String value) {
        assertThat(splitterManager.matchedSplitter(value))
                .isInstanceOf(CustomSplitter.class);
    }

    private static Stream<Arguments> customSplitterCase() {
        return Stream.of(
                Arguments.of("//;\n0"),
                Arguments.of("//;\n10000"),
                Arguments.of("//;\n1;2;3"),
                Arguments.of("//|\n999"),
                Arguments.of("//|\n0|1|2"),
                Arguments.of("//\\|\n0|1|2"),
                Arguments.of("//.\n1"),
                Arguments.of("//.\n10011.2.3"),
                Arguments.of("//^\n200^22"),
                Arguments.of("//*\n1*2*3*"),
                Arguments.of("//\\*\n1*2*3*")
        );
    }
}
