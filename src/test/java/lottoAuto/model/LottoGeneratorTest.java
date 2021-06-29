package lottoAuto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @DisplayName("List<Lotto>를 생성할 수 있다.")
    @Test
    public void LottoGeneratorTest(){
        LottoGenerator lottoGenerator = new LottoGenerator(3);
        assertThat(lottoGenerator.getLottos()).hasSize(3);
    }
}
