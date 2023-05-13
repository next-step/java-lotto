package step2;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ListTest {

    @Test
    void ListTest() {
        List<Integer> numList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 45; i++) numList.add(i);
        Collections.shuffle(numList);

        numList = numList.subList(0, 6);
    }
}
