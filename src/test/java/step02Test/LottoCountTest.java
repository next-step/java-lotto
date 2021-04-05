package step02Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.LottoCount;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCountTest {

    @Test
    @DisplayName("입력한 돈에 맞게 로또 개수 출력 테스트")
    void calculationCount() {
        assertThat(LottoCount.calculationCount(5000)).isEqualTo(5);
    }
}
