package domain;

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


        List<Operation> collect = IntStream.iterate(0, i -> i + 1)
                .limit(splits.length)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> Operation.toOperation(splits[i]))
                .collect(Collectors.toList());

        assertThat(collect)
                .containsExactly(Operation.toOperation("+"),
                        Operation.toOperation("+"),
                        Operation.toOperation("-"),
                        Operation.toOperation("/"));
    }


}
