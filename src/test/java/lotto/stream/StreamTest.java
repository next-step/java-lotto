package lotto.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StreamTest {

    @DisplayName("1부터 45까지의 숫자를 생성한다.")
    @Test
    void stream_range() {
        List<Integer> list = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(list);
        list = list.subList(0, 6);
        Collections.sort(list);
        System.out.println(list);

        assertThat(list.size()).isEqualTo(6);
    }
}
