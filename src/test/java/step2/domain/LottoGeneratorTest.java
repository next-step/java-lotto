package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    @DisplayName("입력받은 수만큼의 로또가 생성되는 지 확인")
    void generateLottos() {
        assertThat(LottoGenerator.generateLottos(5).getSize()).isEqualTo(5);
    }
}
