package stringCalculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import stringCalculator.domain.Operand;

public class OperandTest {

    @Test
    @DisplayName("주어진 값이 제대로 split 되는지 확인한다.")
    void test1(){
        String input = "2 + 3 * 4";
        Queue<String> expectingResult = new ArrayDeque<>(Arrays.asList("2", "+", "3", "*", "4"));

        assertThat(new Operand(input).equals(expectingResult)).isTrue();
    }
}
