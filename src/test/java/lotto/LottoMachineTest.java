package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("로또 1장에 6개의 번호가 생성된다")
    @Test
    void generateSixNumbers() {
        List<Integer> generated = LottoMachine.generateLotto();
        assertThat(generated).hasSize(6);
    }
}
