package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionsStudyTest {

    @Test
    void shuffle_학습테스트() {
        //given
        List<Integer> list = Arrays.asList(1, 2, 3);
        int originSize = list.size();
        int value1 = list.get(0);
        int value2 = list.get(1);

        //when
        Collections.shuffle(list);

        //then
        assertThat(originSize).isEqualTo(list.size());
        assertThat(value1).isIn(list);
        assertThat(value2).isIn(list);
    }
}
