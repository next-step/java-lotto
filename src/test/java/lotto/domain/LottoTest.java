package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 로또_개수_구하기() {
        Lottos lottos = Lottos.of(14000);
        assertThat(lottos.getLottoCount()).isEqualTo(14);
    }

    @Test
    void 로또_자동_생성() {
        Lotto lotto = Lotto.createLotto();
        // 같지 않다고 나오는데 어떻게 테스트 해야 할지 모르겠습니다..
        //assertThat(lotto).isEqualTo(Lotto.createLotto());
    }

}
