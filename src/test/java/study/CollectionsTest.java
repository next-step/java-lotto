package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class CollectionsTest {

    @Test
    @DisplayName("셔플/시드를 주고 셔플/섞인결과 반환")
    void shuffle() {
        // given
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        // when
        Collections.shuffle(list, new Random(0));
        // then
        assertThat(list).containsExactly(2, 1, 4, 3, 7, 5, 6);
    }

    @Test
    @DisplayName("셔플/시드를 주고 셔플/섞인결과 반환")
    void sort() {
        // given
        List<Integer> list = new ArrayList<>(List.of(6, 5, 2, 7));
        // when
        Collections.sort(list);
        // then
        assertThat(list).containsExactly(2, 5, 6, 7);
    }
}
