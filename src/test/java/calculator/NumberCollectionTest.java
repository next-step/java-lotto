package calculator;

import common.NumberElement;
import common.NumberCollection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberCollectionTest {

    @ParameterizedTest
    @MethodSource("provideSum")
    void sum(String[] source, NumberElement expectSum) {

        NumberCollection elements = new NumberCollection(source);

        NumberElement total = elements.sum();

        assertThat(total).isEqualTo(expectSum);
    }

    private static Stream<Arguments> provideSum() {
        return Stream.of(
                Arguments.of(new String[]{"1"}, new NumberElement(1)),
                Arguments.of(new String[]{"4", "11"}, new NumberElement(15)),
                Arguments.of(new String[]{"8", "1", "50"}, new NumberElement(59))
        );
    }


}