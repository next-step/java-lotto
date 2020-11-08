package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayslipTest {

    private Playslip playslip;

    @BeforeEach
    void setUp() {
        playslip = new Playslip();
    }

    @DisplayName("로또용지는 선택한 번호들을 제공한다.")
    @Test
    void selectNumbers() {
        playslip.selectNumbers(2);
        assertThat(playslip.listNumbers().size()).isEqualTo(2);
    }

    @DisplayName("로또용지는 선택 하지 않으면 번호갯수가 0 이다.")
    @Test
    void zeroSizeOfNominatedNumbers() {
        assertThat(playslip.listNumbers().size()).isEqualTo(0);
    }

    @DisplayName("로또용지는 0개 이하를 선택한 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void noPositiveNumberSelection(int selection) {
        assertThatThrownBy(() -> playslip.selectNumbers(selection)) //
                .hasMessage(Playslip.ONLY_POSITIVE_NUMBERS);
    }

    @DisplayName("로또용지는 선택번호셋을 여러개 제공한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void listNumbers(int selection) {
        playslip.selectNumbers(selection);
        List<Set<Integer>> nominatedNumbers = playslip.listNumbers();
        assertThat(nominatedNumbers.size()).isEqualTo(selection);
    }

    @DisplayName("번호셋은 6개의 번호를 가지고 있다.")
    @Test
    void sixNumbers() {
        playslip.selectNumbers(1);
        List<Set<Integer>> nominatedNumbers = playslip.listNumbers();
        for (Set<Integer> nominatedNumber : nominatedNumbers) {
            assertThat(nominatedNumber.size()).isEqualTo(6);
        }
    }

    public static class Playslip {
        public static final String ONLY_POSITIVE_NUMBERS = "선택은 1개 이상만 가능합니다.";
        public static final List<Integer> NUMBER_POOL = makeNumberPool();
        private static final int MAX_SELECT_NUMBER = 45;

        private int size;

        public void selectNumbers(int size) {
            if (size < 1) {
                throw new IllegalArgumentException(ONLY_POSITIVE_NUMBERS);
            }
            this.size = size;
        }

        public List<Set<Integer>> listNumbers() {
            List<Set<Integer>> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                result.add(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
            }
            return result;
        }

        private static List<Integer> makeNumberPool() {
            List<Integer> selectableNumberSource = new ArrayList<>();
            for (int i = 0; i < MAX_SELECT_NUMBER; i++) {
                selectableNumberSource.add(i);
            }
            return Collections.unmodifiableList(selectableNumberSource);
        }
    }
}
