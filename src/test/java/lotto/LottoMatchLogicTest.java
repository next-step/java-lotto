package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchLogicTest {

    private LottoMatchLogic lottoMatchLogic;
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void initComputer() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 4, 5, 6, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 5, 6, 7, 8));
        Lottos lottos = new Lottos();
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottoMatchLogic = new LottoMatchLogic(lottos);
    }

    @Test
    @DisplayName("당첨 로직 확인")
    void 담첨_로직_확인() {
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoRanks result = lottoMatchLogic.checkRank(winLotto, new Fee(1000));
        assertThat(result.getLottoRanks())
                .isEqualTo(new LottoRanks(List.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD), new Fee(1000)).getLottoRanks());

    }
}
