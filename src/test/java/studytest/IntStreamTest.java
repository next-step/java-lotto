package studytest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class IntStreamTest {

    @DisplayName("IntStream.range() 테스트")
    @Test
    void test() {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, -3)
            .forEach(list::add);

        Assertions.assertThat(list.size()).isEqualTo(0);
    }
}
