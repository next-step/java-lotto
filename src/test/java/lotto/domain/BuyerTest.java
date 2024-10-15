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
        List<Lotto> lottoList = new ArrayList<>();
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6);

        lottoList.add(new Lotto(lottoNumber));
        Lottos lottos = new Lottos(lottoList);

        Buyer buyer = new Buyer(lottos);

        assertThat(buyer.getLottoNumbers().get(0)).isEqualTo(lottoNumber);
        assertThat(buyer.getBuyCount()).isEqualTo(1);

    }



    @Test
    void create_usingNumberGenInterface() {

        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6);

        Buyer buyer = new Buyer(1, new TestLottoNumberGenerator(1,2,3,4,5,6));
        assertThat(buyer.getLottoNumbers().get(0)).isEqualTo(lottoNumber);
        assertThat(buyer.getBuyCount()).isEqualTo(1);
        assertThat(buyer.getWinningResult(lottoNumber).get(LottoRankingEnum.FIRST_PRIZE)).isEqualTo(1);
    }

    public static class TestLottoNumberGenerator implements LottoNumberGenerator {

        private List<Integer> values;

        public TestLottoNumberGenerator(Integer... values) {
            this.values = Arrays.asList(values);
        }

        @Override
        public List<List<Integer>> genLottoNumbers(int cnt) {
            return Arrays.asList(values);
        }
    }

    @Test
    void getRateOfReturn_normal() {
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(lottoNumber));

        Buyer buyer = new Buyer(new Lottos(lottoList));
        assertThat(buyer.getRateOfReturn(lottoNumber)).isEqualByComparingTo(LottoRankingEnum.FIRST_PRIZE.getWinningAmount().divide(new BigDecimal(1000), 2, RoundingMode.DOWN));

    }

    @Test
    void getRateOfReturn_zero() {
        Buyer buyer = new Buyer(new Lottos(Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6)))));
        assertThat(buyer.getRateOfReturn(Arrays.asList(7,8,9,10,11,12))).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void getWinningResult_normal() {
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6);
        Buyer buyer = new Buyer(new Lottos(Arrays.asList(new Lotto(lottoNumber), new Lotto(lottoNumber))));
        Map<LottoRankingEnum, Integer> result = buyer.getWinningResult(lottoNumber);
        assertThat(result.keySet()).hasSize(1);
        assertThat(result.get(LottoRankingEnum.FIRST_PRIZE)).isEqualTo(2);
        assertThat(result.keySet()).contains(LottoRankingEnum.FIRST_PRIZE);
    }

    @Test
    void getWinningResult_zero() {
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6);
        Buyer buyer = new Buyer(new Lottos(Arrays.asList(new Lotto(lottoNumber))));
        assertThat(buyer.getWinningResult(Arrays.asList(7,8,9,10,11,12))).isEmpty();
    }

}
