package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersTest {

    @Test
    void create() {
        List<Integer> inputList = Arrays.asList(4,4,4);

        Numbers numbers = Numbers.create(inputList);
    }
}
