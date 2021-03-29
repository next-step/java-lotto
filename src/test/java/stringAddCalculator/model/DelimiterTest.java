package stringAddCalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterTest {


    @Test
    void getDelimiterTest() {
        assertThat(Delimiter.getDelimiter()).contains(":",",");
    }

    @Test
    void addDelimiterTest() {
        Delimiter.addDelimiter("-");
        assertThat(Delimiter.getDelimiter()).contains(":",",","-");
    }
}