package lotto;


import lotto.domain.LottoMatchInformation;
import lotto.domain.LottoMatchNumbers;
import lotto.domain.LottoStatistics;
import lotto.domain.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoStatisticsTest {

    @DisplayName("LottoStatistics 객체를 생성하면 로또에 대한 정보를 가져올 수 있다.")
    @Test
    void lottoStatisticsCreateTest() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        Map<Integer, LottoMatchInformation> information = lottoStatistics.getInformation();

        assertThat(information.get(3).getPrize()).isEqualTo(5_000);
        assertThat(information.get(4).getPrize()).isEqualTo(50_000);
        assertThat(information.get(5).getPrize()).isEqualTo(1_500_000);
        assertThat(information.get(6).getPrize()).isEqualTo(2_000_000_000);
    }

    @DisplayName("LottoMatchNumbers를 전달하면 총 상금을 가져올 수 있다.")
    @Test
    void getTotalPrize() {
        LottoMatchNumbers lottoMatchNumbers = new LottoMatchNumbers();
        lottoMatchNumbers.put(5);
        lottoMatchNumbers.put(4);
        LottoStatistics lottoStatistics = new LottoStatistics();

        assertThat(lottoStatistics.getTotalPrize(lottoMatchNumbers)).isEqualTo(1_550_000);
    }

    @DisplayName("구매 정보와 총 상금을 전달하면 구매금액에 대한 비율을 가져올 수 있다.")
    @Test
    void getRate() {
        Purchase purchase = new Purchase(8000, Purchase.purchaseCount(8000));
        double totalPrize = 5_000_000;
        LottoStatistics lottoStatistics = new LottoStatistics();

        assertThat(lottoStatistics.getRate(purchase, totalPrize)).isEqualTo(625.00);
    }
}