package domain.step1;

import domain.step1.Operator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {

    @Test
    public void stream_index_test() throws Exception {
        String expression = "a + b + c - d / z";

        String[] splits = expression.split(" ");


        List<Operator> collect = IntStream.iterate(0, i -> i + 1)
                .limit(splits.length)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> Operator.toOperation(splits[i]))
                .collect(Collectors.toList());

        assertThat(collect)
                .containsExactly(Operator.toOperation("+"),
                        Operator.toOperation("+"),
                        Operator.toOperation("-"),
                        Operator.toOperation("/"));
    }


}
