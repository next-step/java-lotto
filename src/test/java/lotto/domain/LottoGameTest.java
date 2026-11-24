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
}
