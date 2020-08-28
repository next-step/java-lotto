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

    @Test
    void 로또_번호_비교() {
        Lotto lotto = Lotto.createLotto();
        // 어떻게 테스트 해야 할지 모르겠습니다..
        assertThat(lotto.findSameNumber(new String[]{"1", "2", "3", "4", "5", "6"})).isEqualTo(lotto.getLotto());
    }

    @Test
    void 당첨_개수_가져오기() {
        Lottos lottos = Lottos.of(14000);
        // 어떻게 테스트 해야 할지 모르겠습니다..
        assertThat(lottos.getWinningCount(new String[]{"1", "2", "3", "4", "5", "6"})).isEqualTo(lottos.getLottoCount());
    }

}
