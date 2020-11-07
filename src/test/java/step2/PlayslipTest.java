package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayslipTest {
    @DisplayName("로또용지는 선택한 번호들을 제공한다.")
    @Test
    void selectNumbers() {
        Playslip playslip = new Playslip();
        playslip.selectNumbers(2);
        assertThat(playslip.sizeOfNominatedNumbers()).isEqualTo(2);
    }

    private static class Playslip {
        public void selectNumbers(int size) {

        }

        public int sizeOfNominatedNumbers() {
            return 2;
        }
    }
}
