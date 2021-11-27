package edu.nextstep.camp.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionTest {
    @Test
    public void shuffle() {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10,11,12);
        List<Integer> deck = new ArrayList<>(list);
        Collections.shuffle(deck);
        assertThat(list).containsExactlyInAnyOrderElementsOf(deck);
        assertThat(list).isNotSameAs(deck);

        List<Integer> deck2 = new ArrayList<>(list);
        Collections.shuffle(deck2);
        assertThat(deck).containsExactlyInAnyOrderElementsOf(deck2);
        assertThat(deck).isNotSameAs(deck2);
    }
}
