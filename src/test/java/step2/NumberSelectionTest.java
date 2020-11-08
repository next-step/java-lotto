package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSelectionTest {
    @DisplayName("6개의 번호를 선택할 수 있다.")
    @Test
    void sixNumberSelection() {
        NaturalSelection selection = new NaturalSelection();
        Set<Integer> numberSet = selection.select();
        assertThat(numberSet.size()).isEqualTo(6);
    }


    private static class NaturalSelection {

        public Set<Integer> select() {
            return new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        }
    }
}
