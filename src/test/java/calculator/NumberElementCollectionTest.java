package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberElementCollectionTest {

    @Test
    void sum() {

        String[] source = {"1", "2"};
        NumberElementCollection elements = new NumberElementCollection(source);

        int total = elements.sum();

        assertThat(total).isEqualTo(3);
    }
}