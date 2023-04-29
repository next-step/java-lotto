package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueTest {

    @Test
    void 입력한_순서대로_값이_출력되는지() {
        List<String> operations = List.of("*", "-", "/", "+", "+");

        Queue<String> queue = new LinkedList<>(operations);

        for (String s : operations) {
            Assertions.assertThat(s).isEqualTo(queue.poll());
        }
    }
}
