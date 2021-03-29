package stringAddCalculator.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterTest {

    @BeforeAll
    static void initializeTest(){
        Delimiter.addDelimiter(";|,");
    }

    @Test
    void getDelimiterTest() {
        assertThat(Delimiter.getDelimiter()).contains(";",",");
    }

    @Test
    void addDelimeterTest() {
        Delimiter.addDelimiter("-");
        assertThat(Delimiter.getDelimiter()).contains(";",",","-");
    }
}