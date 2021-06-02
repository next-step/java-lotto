package study.ascii92der.lotto.step3n4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    @DisplayName("로또 번호 자동 생성 테스트")
    void create() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.generate()).isInstanceOf(Lotto.class);
    }
}
