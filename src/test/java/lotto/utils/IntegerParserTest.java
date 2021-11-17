package lotto.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

class IntegerParserTest {

//    @DisplayName()
    @Test
    void test() {
        //given
        String s = "1, 2, 3, 4, 5, 6";
        List<Integer> integers = IntegerParser.listOf(s);
        System.out.println("integers = " + integers);

        //when

        //then
    }

}
