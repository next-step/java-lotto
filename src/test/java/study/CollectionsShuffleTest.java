package study;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsShuffleTest {


    @Test
    void collectionsShuffleTest() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);

        Collections.shuffle(lotto);

        System.out.println(lotto);
    }
}
