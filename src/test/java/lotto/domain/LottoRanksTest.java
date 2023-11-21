package lotto.domain;

import lotto.domain.strategy.AutoLottoGeneration;
import lotto.domain.strategy.LottoGeneration;
import lotto.domain.strategy.ManualLottoGeneration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRanksTest {
    private static final LottoGeneration LOTTO_GENERATION = new AutoLottoGeneration(LottoNumberCache.values());
    private LottoRanks lottoRanks;

    @BeforeEach
    void create() {
        List<LottoGeneration> generationList = new ArrayList<>();
        generationList.add(new ManualLottoGeneration(Arrays.asList(1, 2, 3, 4, 5, 6)));
        generationList.add(new ManualLottoGeneration(Arrays.asList(1, 2, 3, 4, 5, 7)));

        Lottos lottos = new Lottos(new PurchaseQuantity(0), generationList, LOTTO_GENERATION);
        Lotto winLotto = new Lotto(new ManualLottoGeneration(Arrays.asList(1, 2, 3, 4, 5, 6)).generate());
        LottoNumber bonus = new LottoNumber(7);

        lottoRanks = new LottoRanks(lottos, winLotto, bonus);
    }

    @Test
    @DisplayName("로또 목록과 당첨 번호를 비교하여 로또 당첨 목록을 생성한다")
    void 로또당첨목록_확인() {
        assertThat(lottoRanks.findLottoResult()).hasSize(5)
                .containsOnly(entry(LottoRank.FIFTH, 0)
                        , entry(LottoRank.FOURTH, 0)
                        , entry(LottoRank.THIRD, 0)
                        , entry(LottoRank.SECOND, 1)
                        , entry(LottoRank.FIRST, 1));
    }

    @Test
    @DisplayName("당첨된 로또 금액을 확인")
    void 로또당첨금_확인() {
        assertThat(lottoRanks.findPrizeMoney()).isEqualTo(new Money(2_000_000_000L + 30_000_000L));
    }
}
