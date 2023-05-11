package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    public void 로또_구입금액을_입력하면_구입금액에_해당하는_로또를_발행한다() {
        //given
        int money = 14000;
        LottoGenerator lottoGenerator = new LottoGenerator();
        //when
        lottoGenerator.generateLottoResultsFromMoney(money);
        LottoResults lottoResults = lottoGenerator.getLottoResults();
        List<int[]> lottoResultList = lottoResults.getLottoResults();
        //then
        assertThat(lottoResultList).hasSize(14);
        for (int[] lottoNum : lottoResultList) {
            assertThat(lottoNum).hasSize(6);
        }
    }
}
