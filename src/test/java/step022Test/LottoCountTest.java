package step022Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step022.LottoCount;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCountTest {

    @Test
    @DisplayName("돈이 들어온만큼 로또 갯수가 잘 생성되는지 확인")
    void calculationCount() {
        LottoCount lottoCount = new LottoCount();
        lottoCount.calculationCount(4000);
        assertThat(lottoCount.getCount()).isEqualTo(4);
    }
}
