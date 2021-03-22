package study.step2;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step2.domain.LottoFactory;
import study.step2.domain.Lottos;

public class LottosTest {
    @Test
    @DisplayName("금액에 따른 로또 생성 테스트")
    void purchase() {
        Lottos lottos = LottoFactory.purchase(12000);
        assertThat(lottos.getLottos().size()).isEqualTo(12);
    }
}
