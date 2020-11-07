package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayslipTest {
    @DisplayName("로또용지는 선택한 번호들을 제공한다.")
    @Test
    void selectNumbers() {
        Playslip playslip = new Playslip();
        playslip.selectNumbers(2);
        assertThat(playslip.sizeOfNominatedNumbers()).isEqualTo(2);
    }

    @DisplayName("로또용지는 선택 하지 않으면 번호갯수가 0 이다.")
    @Test
    void zeroSizeOfNominatedNumbers() {
        Playslip playslip = new Playslip();
        assertThat(playslip.sizeOfNominatedNumbers()).isEqualTo(0);
    }

    @DisplayName("로또용지는 0개 이하를 선택한 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void noPositiveNumberSelection(int selection) {
        Playslip playslip = new Playslip();
        assertThatThrownBy(() -> playslip.selectNumbers(selection)) //
                .hasMessage(Playslip.ONLY_POSITIVE_NUMBERS);
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
    }
}
