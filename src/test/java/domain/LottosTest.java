package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottosTest {

    @Test
    void 자동_생성_개수확인() {
        Lottos lottos = new Lottos().buy(5);
        assertThat(lottos.getLottos()).hasSize(5);
    }

    @Test
    void 수동_생성_개수확인() {
        Lottos lottos = new Lottos().buy(new String[]{"1,2,3,4,5,6", "2,3,4,5,6,7", "3,4,5,6,7,8"});
        assertThat(lottos.getLottos()).hasSize(3);
    }

    @Test
    void 구입후_동일_객체확인() {
        Lottos lottos = new Lottos();
        assertThat(lottos.buy(3)).isEqualTo(lottos);
    }

    @Test
    void 구입갯수_확인() {
        assertThat(new Lottos().buy(3).getLottos()).hasSize(3);
    }

    @Test
    void 보너스볼_확인() {

        Lottos lottos = new Lottos(new ArrayList<>() {{
            add(new Lotto(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6))));
        }});

        assertThat(lottos.calculateWinResult(new LottoNumbers(List.of(1, 2, 3, 4, 5, 7)), 6)).containsKey(PrizeEnum.FIVE_HIT_BONUS_HIT);
    }

    @Test
    void 일등_확인() {
        Lottos lottos = new Lottos(new ArrayList<>() {{
            add(new Lotto(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6))));
        }});

        assertThat(lottos.calculateWinResult(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)), 7)).containsKey(PrizeEnum.SIX_HIT);
    }
}