package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    void 구입금액만큼_로또개수_생성하기() {
        Lottos lottos = new Lottos("14000");
        int lottoCnt = lottos.getLottosCnt();

        assertThat(lottoCnt).isEqualTo(14);
    }

    @Test
    void 로또갯수만큼_번호확인하기() {
        Lottos lottos = new Lottos("14000");
        System.out.println(lottos.getLottos());
    }

}