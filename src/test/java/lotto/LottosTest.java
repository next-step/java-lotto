package lotto;

import lotto.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    @Test
    void 로또개수입력() {
        Lottos lottos = new Lottos(5000, 3);
        assertThat(lottos.totalQuantity()).isEqualTo(5);
        assertThat(lottos.autoLottoQuantity()).isEqualTo(2);
    }

    @Test
    void 금액을_1000원단위로_입력_안한경우() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lottos(1100, 3));
    }

    @Test
    void addLotto() {
        Lottos lottos = createLottos();

        Assertions.assertThat(lottos.getSize()).isEqualTo(2);
    }

    @Test
    void countRank() {
        Lottos lottos = createLottos();

        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 11, 12, 13), 7);
        RankCount rankCount = new RankCount();
        lottos.countRank(rankCount, winningNumbers);

        Assertions.assertThat(rankCount.numberOfRank(Rank.FIFTH)).isEqualTo(2);
    }

    private Lottos createLottos() {
        Lottos lottos = new Lottos(2000, 2);
        Lotto lotto1 = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        lottos.saveLotto(Arrays.asList(lotto1, lotto2));
        return lottos;
    }
}
