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

    private static class NaturalSelection {

        public Set<Integer> select(List<Integer> selectableNumbers) {
            return new HashSet<>(selectableNumbers.subList(0, 6));
        }

    }
}
