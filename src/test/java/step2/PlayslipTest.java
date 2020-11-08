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
        assertThat(playslip.sizeOfNominatedNumbers()).isEqualTo(2);
    }

    @DisplayName("로또용지는 선택 하지 않으면 번호갯수가 0 이다.")
    @Test
    void zeroSizeOfNominatedNumbers() {
        assertThat(playslip.sizeOfNominatedNumbers()).isEqualTo(0);
    }

    @DisplayName("로또용지는 0개 이하를 선택한 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void noPositiveNumberSelection(int selection) {
        assertThatThrownBy(() -> playslip.selectNumbers(selection)) //
                .hasMessage(Playslip.ONLY_POSITIVE_NUMBERS);
    }

    @DisplayName("로또용지는 선택번호셋을 제공한다.")
    @Test
    void listNumbers() {
        playslip.selectNumbers(1);
        List<Set<Integer>> nominatedNumbers = playslip.listNumbers();
        assertThat(nominatedNumbers.size()).isEqualTo(1);
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

    private static class Playslip {
        public static final String ONLY_POSITIVE_NUMBERS = "선택은 1개 이상만 가능합니다.";
        private int size;

        public void selectNumbers(int size) {
            if (size < 1) {
                throw new IllegalArgumentException(ONLY_POSITIVE_NUMBERS);
            }
            this.size = size;
        }

        public int sizeOfNominatedNumbers() {
            return this.size;
        }

        public List<Set<Integer>> listNumbers() {
            return Collections.singletonList(new HashSet<>());
        }
    }
}
