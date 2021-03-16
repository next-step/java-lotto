package step1;

import org.junit.jupiter.api.Test;
import step1.controller.StringAddCalculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringAddStringArrayConverterTest {
    
    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        int expected = 0;
        assertEquals(result, expected);

        result = StringAddCalculator.splitAndSum("");
        assertEquals(result, expected);
    }

    @Test
    void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        int expected = 1;
        assertEquals(result, expected);
    }

    @Test
    void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        int expected = 3;
        assertEquals(result, expected);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        int expected = 6;
        assertEquals(result, expected);
    }

    @Test
    void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        int expected = 6;
        assertEquals(result, expected);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThrows(
                RuntimeException.class,
                () -> StringAddCalculator.splitAndSum("-1,2,3"));
    }

}