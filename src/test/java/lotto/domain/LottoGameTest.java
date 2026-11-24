package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @Test
    void 생성_방법을_전달받아_구입_금액만큼_로또를_생성한다() {
        LottoGenerator fixedGenerator = () -> new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoGame lottoGame = new LottoGame(new PurchaseAmount(14000), fixedGenerator);

        assertThat(lottoGame.getLottos())
                .hasSize(14)
                .allSatisfy(lotto -> assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 당첨_번호를_입력받아_로또_결과를_반환한다() {
        LottoGenerator fixedGenerator = () -> new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoGame lottoGame = new LottoGame(new PurchaseAmount(3000), fixedGenerator);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 10, 11, 12)));

        LottoResult result = lottoGame.getResult(winningLotto);

        assertThat(result.getCount(Rank.FOURTH)).isEqualTo(3);
        assertThat(result.getProfitRate()).isEqualTo(5.0);
    }
}
