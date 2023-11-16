package studytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class TreeSetTest {

    @DisplayName("TreeSet 테스트")
    @Test
    void test() {
        // given
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(32);
        tree.add(23);
        tree.add(39);
        tree.add(16);

        // when
        tree.forEach(System.out::println);
    }
}
