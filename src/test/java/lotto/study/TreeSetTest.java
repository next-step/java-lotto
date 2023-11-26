package lotto.study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeSetTest {

    @Test
    void treeSetTest() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(1);
        assertThat(treeSet.toString()).isEqualTo("[1, 2, 3]");
    }

    @Test
    void listToTreeSetTest() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        TreeSet<Integer> treeSet = new TreeSet<>(list);
        assertThat(treeSet.toString()).isEqualTo("[1, 2, 3]");
    }

}
