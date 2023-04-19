package lotto.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class shuffleTest {
    @Test
    @DisplayName("Collections.shuffle() 메서드 학습테스트")
    void name() {
        final List<Integer> target = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final List<Integer> copy = new ArrayList<>(target);

        Collections.shuffle(copy);

        System.out.println(target);
        System.out.println(copy);
    }
}
