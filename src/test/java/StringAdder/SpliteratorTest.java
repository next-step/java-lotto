package StringAdder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static StringAdder.StringAdderTestUtil.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SpliteratorTest {
    private final int START_POINT = 0;
    private final int LENGTH_OF_INPUT = 5;

    private final List<Integer> separated = Arrays.asList(1,2,3,4,5);

    @Test
    void testHasNextTrue() {
        Spliterator spliterator = new Spliterator(INPUT_WITH_COLON);
        assertThat(spliterator.hasNext()).isTrue();
    }

    @Test
    void testHasNextFalse() {
        Spliterator spliterator = new Spliterator(INPUT_WITH_COLON);
        IntStream.range(START_POINT, LENGTH_OF_INPUT)
                .forEach(i -> spliterator.next());

        assertThat(spliterator.hasNext()).isFalse();
    }

    @Test
    void testNextThrowsExceptionWhenNoElementIsLeft() {
        Spliterator spliterator = new Spliterator(INPUT_WITH_COLON);
        IntStream.range(START_POINT, LENGTH_OF_INPUT)
                .forEach(i -> spliterator.next());

        assertThatThrownBy(spliterator::next).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void testInputWithColon() {
        Spliterator spliterator = new Spliterator(INPUT_WITH_COLON);

        separated.forEach(i -> assertThat(spliterator.next()).isEqualTo(new Num(i)));
    }

    @Test
    void testInputWithComma() {
        Spliterator spliterator = new Spliterator(INPUT_WITH_COMMA);

        separated.forEach(i -> assertThat(spliterator.next()).isEqualTo(new Num(i)));
    }

    @Test
    void testInputWithColonAndComma() {
        Spliterator spliterator = new Spliterator(INPUT_WITH_COLON_AND_COMMA);

        separated.forEach(i -> assertThat(spliterator.next()).isEqualTo(new Num(i)));
    }

    @Test
    void testInputWithCustomSeparator() {
        Spliterator spliterator = new Spliterator(INPUT_WITH_CUSTOM_SEPARATOR);

        separated.forEach(i -> assertThat(spliterator.next()).isEqualTo(new Num(i)));
    }

    @Test
    void testInputWithCustomSeparatorAndBasicSeparator() {
        Spliterator spliterator = new Spliterator(INPUT_WITH_CUSTOM_SEPARATOR_AND_BASIC_SEPARATOR);

        separated.forEach(i -> assertThat(spliterator.next()).isEqualTo(new Num(i)));
    }

    @Test
    void testInputWithNotNumberThrowRunTimeException() {
        Spliterator spliterator = new Spliterator(INPUT_WITH_NOT_NUMBER);

        spliterator.next();
        assertThatThrownBy(() -> spliterator.next()).isInstanceOf(RuntimeException.class);
    }

    @Test
    void testInputWithMinusNumberThrowRunTimeException() {
        Spliterator spliterator = new Spliterator(INPUT_WITH_MINUS_NUMBER);

        spliterator.next();
        assertThatThrownBy(() -> spliterator.next()).isInstanceOf(RuntimeException.class);
    }
}
