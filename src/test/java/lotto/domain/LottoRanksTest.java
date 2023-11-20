package lotto.domain;

import lotto.domain.strategy.ManualNumberGeneration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

@DisplayName("로또 당첨 확인 관련 테스트")
public class LottoRanksTest {

    @Test
    @DisplayName("모든 로또 당첨금의 합계를 확인")
    void 당첨금_합계확인() {
        PurchaseQuantity count = new PurchaseQuantity(5);
        LottoNumber bonus = LottoNumber.valueOf(1);
        Lottos lottos = Lottos.generate(new ArrayList<>(), new ManualNumberGeneration(Arrays.asList(1, 2, 3, 4, 5, 6)), count);

        LottoRanks lottoRanks = new LottoRanks(lottos, new Lotto(new ManualNumberGeneration(Arrays.asList(6, 5, 4, 3, 2, 10))), bonus);

        assertThat(lottoRanks.findPrizeMoney()).isEqualTo(new Money(150000000));
    }

    @Test
    @DisplayName("로또당첨 번호와 매치한 결과를 miss를 제외한 랭킹값 모두 리턴")
    void 로또당첨_목록확인() {
        Lotto winList = new Lotto(new ManualNumberGeneration(Arrays.asList(6, 5, 4, 2, 3, 1)));
        LottoNumber bonus = LottoNumber.valueOf(1);

        List<Lotto> list = new ArrayList<>();
        Lotto lotto1 = new Lotto(new ManualNumberGeneration(Arrays.asList(6, 5, 4, 10, 11, 12)));
        Lotto lotto2 = new Lotto(new ManualNumberGeneration(Arrays.asList(1, 2, 3, 20, 21, 22)));
        list.add(lotto1);
        list.add(lotto2);
        Lottos lottos = new Lottos(list);

        LottoRanks lottoRanks = new LottoRanks(lottos, winList, bonus);

        assertThat(lottoRanks.find()).hasSize(5)
                .containsOnly(
                        entry(LottoRank.FIFTH, 2),
                        entry(LottoRank.FOURTH, 0),
                        entry(LottoRank.THIRD, 0),
                        entry(LottoRank.SECOND, 0),
                        entry(LottoRank.FIRST, 0));
    }
}
