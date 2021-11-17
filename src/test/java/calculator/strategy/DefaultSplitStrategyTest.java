package calculator.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DefaultSplitStrategyTest {

    private DefaultSplitStrategy defaultSplitStrategy;

    @BeforeEach
    void setUp() {
        defaultSplitStrategy = new DefaultSplitStrategy();
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.of("1,2,3", ",", new String[]{"1", "2", "3"}),
            Arguments.of("2:1:4:5", ":", new String[]{"2", "1", "4", "5"}),
            Arguments.of("1,2:3", ",|:", new String[]{"1", "2", "3"})
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 스플릿값일치확인(String input, String delimiter, String[] result) {
        assertThat(defaultSplitStrategy.getSplitInput(input, delimiter)).isEqualTo(result);
    }

}
