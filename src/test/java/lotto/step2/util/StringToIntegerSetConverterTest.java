package lotto.step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringToIntegerSetConverterTest {
    @ParameterizedTest
    @MethodSource("inputTextSplitWithCommaAndWhiteSpace")
    @DisplayName("convert 메서드의 입력으로 ', '로 구분된 숫자들이 들어오면, 해당 숫자들을 가진 Set을 만들어서 반환한다.")
    void testConvert(final String text, final Set<Integer> expected) {
        //given
        //when
        final Set<Integer> set = StringToIntegerSetConverter.convert(text);
        
        //then
        assertThat(set).isEqualTo(expected);
    }

    public static Stream<Arguments> inputTextSplitWithCommaAndWhiteSpace() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 8, 9", Set.of(1, 2, 3, 4, 5, 8, 9)),
                Arguments.of("1, 2, 3, 4, 5, 6", Set.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("1, 2, 3, 4, 5", Set.of(1, 2, 3, 4, 5)),
                Arguments.of("1, 2, 3, 4", Set.of(1, 2, 3, 4)),
                Arguments.of("1, 2, 3", Set.of(1, 2, 3)),
                Arguments.of("1, 2", Set.of(1, 2)),
                Arguments.of("1", Set.of(1))
        );
    }
}
