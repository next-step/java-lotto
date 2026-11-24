package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottosTest {

    private static final LottoGenerator FIXED_GENERATOR = () -> new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void 생성_방법을_전달받아_주어진_개수만큼_로또를_생성한다() {
        Lottos lottos = new Lottos(14, FIXED_GENERATOR);

        assertThat(lottos.getLottos())
                .hasSize(14)
                .allSatisfy(lotto -> assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 당첨_번호와_구입_금액을_입력받아_로또_결과를_반환한다() {
        Lottos lottos = new Lottos(3, FIXED_GENERATOR);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 10, 11, 12)));

        LottoResult result = lottos.getResult(winningLotto, new PurchaseAmount(3000));

        assertThat(result.getCount(Rank.FOURTH)).isEqualTo(3);
        assertThat(result.getProfitRate()).isEqualTo(5.0);
    }
}
