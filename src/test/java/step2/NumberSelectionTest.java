package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.PlayslipTest.Playslip.NUMBER_POOL;

public class NumberSelectionTest {
    @DisplayName("입력받은 번호 중 6개의 번호를 선택할 수 있다.")
    @Test
    void sixNumberSelection() {
        NaturalSelection selection = new NaturalSelection();
        Set<Integer> numberSet = selection.select(NUMBER_POOL, 6);
        assertThat(numberSet.size()).isEqualTo(6);
    }

    @DisplayName("선택된 번호는 매번 다르다.")
    @Test
    void naturalSelection() {
        NaturalSelection selection = new NaturalSelection();
        Set<Integer> firstSelection = selection.select(NUMBER_POOL, 6);
        for (int i = 0; i < 1000; i++) {
            assertThat(firstSelection).isNotEqualTo(selection.select(NUMBER_POOL, 6));
        }
    }

    @DisplayName("입력값은 중복을 허용하지 않는다.")
    @Test
    void notAllowedDuplicateNumberPool() {
        assertThatThrownBy(() -> new NaturalSelection().select(Arrays.asList(1, 2, 2, 3), 6)) //
                .isInstanceOf(DuplicateNumberPoolException.class);
    }

    @DisplayName("NumberPool 은 최소 선택갯수 이상 존재해야 한다")
    @Test
    void minimumSelection() {
        assertThatThrownBy(() -> new NaturalSelection().select(Arrays.asList(1, 2, 3), 6)) //
                .isInstanceOf(NotEnoughNumberPoolSizeException.class);
    }

    @DisplayName("선택은 1개 이상이어야 함.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void selectionMoreThen_0(int count) {
        assertThatThrownBy(() -> new NaturalSelection().select(NUMBER_POOL, count)) //
                .isInstanceOf(IllegalCountException.class);
    }

    public static class NaturalSelection {

        public Set<Integer> select(List<Integer> numberPool, int count) {
            Set<Integer> numberPoolSet = new HashSet<>(numberPool);
            if (numberPoolSet.size() != numberPool.size()) {
                throw new DuplicateNumberPoolException();
            }
            if (numberPoolSet.size() < count) {
                throw new NotEnoughNumberPoolSizeException();
            }

            List<Integer> modifiableNumberPool = new ArrayList<>(numberPool);
            Collections.shuffle(modifiableNumberPool);
            return new HashSet<>(modifiableNumberPool.subList(0, count));
        }

    }

    private static class DuplicateNumberPoolException extends IllegalArgumentException {
    }

    private static class NotEnoughNumberPoolSizeException extends IllegalArgumentException {
    }

    private static class IllegalCountException extends IllegalArgumentException {
    }
}
