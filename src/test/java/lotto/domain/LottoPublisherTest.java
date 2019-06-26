package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoPublisherTest {
    private LottoPublisher purchasePublisher;
    private LottoPublisher rankPublisher;

    @BeforeEach
    void setUp() {
        purchasePublisher = new LottoPublisher(14000);
        List<Lotto> lottos = new ArrayList<>();
        Integer[] numbers1 = {11,21,31,17,18,19};
        Integer[] numbers2= {1,2,3,4,5,12};
        Integer[] numbers3 = {1,2,3,4,5,7};
        lottos.add(new Lotto(new LottoNumber(Arrays.asList(numbers1))));
        lottos.add(new Lotto(new LottoNumber(Arrays.asList(numbers2))));
        lottos.add(new Lotto(new LottoNumber(Arrays.asList(numbers3))));
        rankPublisher = new LottoPublisher(lottos);
    }

    @Test
    void getPublishLottoRanks_당첨안됨_2등_3등확인() {
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6");
        List<Rank> ranks = rankPublisher.getPublishLottoRanks(winnerLotto, 7);
        assertThat(ranks.contains(Rank.THIRD)).isTrue();
        assertThat(ranks.contains(Rank.SECOND)).isTrue();
        assertThat(ranks.contains(Rank.NONE)).isTrue();
    }

    @Test
    void IllegalArgumentException_투입금액유효성검사() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            purchasePublisher.validatePurchaseAmount(0);
            purchasePublisher.validatePurchaseAmount(-1000);
            purchasePublisher.validatePurchaseAmount(11500);
        });
    }

    @Test
    void 구매한로또개수확인() {
        assertThat(purchasePublisher.getPublishLotto().size()).isEqualTo(14);
    }

    @Test
    void 생성자금액만큼로또생성() {
        assertThat(purchasePublisher.getPublishLotto().size()).isEqualTo(14);
    }

    @Test
    void getRevenueRatio_수익률구하기() {
        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6");
        RankReward rankReward = new RankReward(rankPublisher.getPublishLottoRanks(winnerLotto, 7));
        double revenueRatio = rankPublisher.getRevenueRatio(rankReward.getRewardWinningMoney());
        System.out.println("revenueRatio:::"+revenueRatio);
        assertThat(RevenueRatio.valueOf(revenueRatio)).isEqualTo(RevenueRatio.PROFIT);
    }
}
