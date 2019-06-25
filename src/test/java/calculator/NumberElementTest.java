package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberElementTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "55"})
    void parseStringToNumber(String stringValue) {

        NumberElement element = new NumberElement(stringValue);

        assertThat(element).isEqualTo(new NumberElement(Integer.parseInt(stringValue)));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void parseEmptyOrNull(String stringValue) {

        NumberElement element = new NumberElement(stringValue);

        assertThat(element).isEqualTo(new NumberElement(0));
    }
}