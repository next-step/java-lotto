package lotto.numberdrawer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ShuffledNumberDrawerTest {

    @Test
    @DisplayName("1부터 BOUND 사이의 숫자 6개를 반환")
    void drawnNumbers() {
        ShuffledNumberDrawer numberDrawer = new ShuffledNumberDrawer();
        int bound = 45;
        int size = 6;
        List<Integer> numbers = numberDrawer.drawnNumbers(bound, size);

        assertThat(numbers).hasSize(size);
        assertThat(numbers).allMatch((number) -> number > 0 && number <= bound);
    }
}