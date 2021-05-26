package study.ascii92der.lotto.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    @DisplayName("로또 번호 자동 생성 테스트")
    void lottoNumberGeneratorTest() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.generate().size()).isEqualTo(6);
    }
}
