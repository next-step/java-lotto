package lotto.model;

import org.junit.jupiter.api.Test;

public class LottoResultMapTest {

    @Test
    void test(){

        LottoResultMap lottoResultMap = new LottoResultMap(14000);
        lottoResultMap.plusByNumKeyMatched(4);
        lottoResultMap.printResult();
    }
}
