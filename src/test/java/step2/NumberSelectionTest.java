package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.PlayslipTest.Playslip.NUMBER_POOL;

public class NumberSelectionTest {
    @DisplayName("입력받은 번호 중 6개의 번호를 선택할 수 있다.")
    @Test
    void sixNumberSelection() {
        NaturalSelection selection = new NaturalSelection();
        Set<Integer> numberSet = selection.select(NUMBER_POOL);
        assertThat(numberSet.size()).isEqualTo(6);
    }

    @DisplayName("선택된 번호는 매번 다르다.")
    @Test
    void naturalSelection() {
        NaturalSelection selection = new NaturalSelection();
        Set<Integer> firstSelection = selection.select(NUMBER_POOL);
        for (int i = 0; i < 1000; i++) {
            assertThat(firstSelection).isNotEqualTo(selection.select(NUMBER_POOL));
        }
    }

    private static class NaturalSelection {

        public Set<Integer> select(List<Integer> numberPool) {
            List<Integer> modifiableNumberPool = new ArrayList<>(numberPool);
            Collections.shuffle(modifiableNumberPool);
            return new HashSet<>(modifiableNumberPool.subList(0, 6));
        }

    }
}
