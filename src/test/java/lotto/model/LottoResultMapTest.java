package lotto.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultMapTest {

    @Test
    void test(){

        LottoResultMap lottoResultMap = new LottoResultMap(14000);
        lottoResultMap.plusByNumKeyMatched(4);
        lottoResultMap.printResult();
    }

    @Test
    void 수익률_계산(){
        LottoResultMap lottoResultMap = new LottoResultMap(5000);
        lottoResultMap.plusByNumKeyMatched(3);
        BigDecimal result = lottoResultMap.calculateProfitRate(5000);
        assertThat(result.doubleValue()).isEqualTo((double)1);
        //calculateProfitRate

    }
}
