package lotto.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class BuyerTest {

    @Test
    void create() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        Buyer buyer = new Buyer(lottos);
        assertThat(buyer.getLottos()).isEqualTo(lottos);
    }

    @Test
    void getRateOfReturn_normal() {
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(lottoNumber));
        Buyer buyer = new Buyer(lottos);
        assertThat(buyer.getRateOfReturn(lottoNumber)).isEqualByComparingTo(LottoRankingEnum.FIRST_PRIZE.getWinningAmount().divide(new BigDecimal(1000), 2, RoundingMode.DOWN));

    }

    @Test
    void getRateOfReturn_zero() {
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(lottoNumber));
        Buyer buyer = new Buyer(lottos);
        assertThat(buyer.getRateOfReturn(Arrays.asList(7,8,9,10,11,12))).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void getWinningResult_normal() {
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(lottoNumber));
        lottos.add(new Lotto(lottoNumber));
        Buyer buyer = new Buyer(lottos);
        Map<LottoRankingEnum, Integer> result = buyer.getWinningResult(lottoNumber);
        assertThat(result.keySet()).hasSize(1);
        assertThat(result.get(LottoRankingEnum.FIRST_PRIZE)).isEqualTo(2);
        assertThat(result.keySet()).contains(LottoRankingEnum.FIRST_PRIZE);
    }

    @Test
    void getWinningResult_zero() {
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(lottoNumber));

        Buyer buyer = new Buyer(lottos);
        assertThat(buyer.getWinningResult(Arrays.asList(7,8,9,10,11,12))).isEmpty();
    }

}
