package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoYieldTest {

    @Test
    @DisplayName("수익 통계 생성 테스트")
    public void createLottoYieldTest() throws Exception {
        //given
        double profit = 1;
        LottoYield lottoYield = new LottoYield(profit);

        //when

        //then
        assertThat(lottoYield.checkYield(profit)).isTrue();
    }

    @Test
    @DisplayName("이익 문자열 테스트")
    public void stringProfitTest() throws Exception {
        //given
        double profit = 1;
        LottoYield lottoYield = new LottoYield(profit);
        String result = "이익";
        //when

        //then
        assertThat(lottoYield.stringYield()).isEqualTo(result);
    }

    @Test
    @DisplayName("손해 문자열 테스트")
    public void stringLossTest() throws Exception {
        //given
        double profit = 0.99;
        LottoYield lottoYield = new LottoYield(profit);
        String result = "손해";

        //when

        //then
        assertThat(lottoYield.stringYield()).isEqualTo(result);
    }
}
