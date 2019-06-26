package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoPublisherTest {
    private LottoPublisher publisher;
    private LottoPublisher purchasePublisher;
    private LottoPublisher rankPublisher;
    private LottoPublisher revenueRatioPublisher;
    private RankReward rankReward;
    private List<Rank> ranks;
    private RankReward revenueRatioReward;
    private List<Rank> revenueRatioRanks;

    @BeforeEach
    void setUp() {
        publisher = new LottoPublisher();
        purchasePublisher = new LottoPublisher(14000);

        String winNumberStr = "1,2,3,4,5,6";
        List<Lotto> lottos = new ArrayList<>();
        Integer[] same_numbers_5 = {1,2,3,7,8,9};
        Integer[] same_numbers_0_0 = {1,2,9,10,11,12};
        Integer[] same_numbers_0_1 = {1,2,9,10,11,12};
        lottos.add(new Lotto(Arrays.asList(same_numbers_5)));
        lottos.add(new Lotto(Arrays.asList(same_numbers_0_0)));
        lottos.add(new Lotto(Arrays.asList(same_numbers_0_1)));
        rankPublisher = new LottoPublisher(lottos);
        ranks = rankPublisher.getPublishLottoRanks(new WinnerLotto(winNumberStr));
        rankReward = new RankReward(ranks);
        revenueRatioPublisher = new LottoPublisher(3000, lottos);
        revenueRatioRanks = revenueRatioPublisher.getPublishLottoRanks(new WinnerLotto(winNumberStr));
        revenueRatioReward = new RankReward(revenueRatioRanks);

    }

    @Test
    void IllegalArgumentException_투입금액유효성검사() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            publisher.validatePurchaseAmount(0);
            publisher.validatePurchaseAmount(-1000);
            publisher.validatePurchaseAmount(11500);
        });
    }

    @Test
    void 구매한로또개수확인() {
        assertThat(purchasePublisher.getBuyLottoCount()).isEqualTo(14);
    }

    @Test
    void 생성자금액만큼로또생성() {
        assertThat(purchasePublisher.getPublishLotto().size()).isEqualTo(14);
    }

    @Test
    void 생성한로또숫자콘솔출력() {
        for (int i = 0 ; i < purchasePublisher.getBuyLottoCount(); i++) {
            List<Integer> numbers = purchasePublisher.getPublishLotto().get(i).getNumbers();
            List<String> strNumbers = new ArrayList<>();
            for (int j = 0 ; j < LottoNumber.MAX_LOTTO_NUM_COUNT; j++) {
                strNumbers.add(numbers.get(j).toString());
            }
            System.out.println((i+1)+"로또번호["+String.join(",", strNumbers)+"]");
        }
    }

    @Test
    void 생성자에당첨번호로또생성_유효성검사() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            WinnerLotto nullInput = new WinnerLotto(null);
            WinnerLotto fiveNumbers = new WinnerLotto("1,2,3,4,5");
            WinnerLotto notNumber = new WinnerLotto("1,2,3,aaa,5,6");
            WinnerLotto overLottoRange = new WinnerLotto("1,2,3,46,5,6");
            WinnerLotto sameNumber = new WinnerLotto("1,2,3,4,5,5");
        });
    }

    @Test
    void 당첨숫자와일치하는로또숫자개수로Lotto의Rank확인() {
        assertThat(ranks.get(0)).isEqualTo(Rank.FIFTH);
        assertThat(ranks.get(1)).isEqualTo(Rank.NONE);
    }

    @Test
    void rankReward_당첨된로또카운드확인_당첨금액확인() {
        assertThat(rankReward.getGainRanksCounts().get(Rank.FIRST)).isEqualTo(0);
        assertThat(rankReward.getGainRanksCounts().get(Rank.THIRD)).isEqualTo(0);
        assertThat(rankReward.getGainRanksCounts().get(Rank.FOURTH)).isEqualTo(0);
        assertThat(rankReward.getGainRanksCounts().get(Rank.FIFTH)).isEqualTo(1);
        assertThat(rankReward.getGainRanksCounts().get(Rank.NONE)).isEqualTo(2);
        assertThat(rankReward.getRewardWinningMoney()).isEqualTo(5000);
    }

    @Test
    void getRevenueRatio_수익률구하기() {
        double revenueRatio = revenueRatioPublisher.getRevenueRatio(revenueRatioReward.getRewardWinningMoney());
        assertThat(RevenueRatio.valueOf(revenueRatio)).isEqualTo(RevenueRatio.PROFIT);
    }
}
