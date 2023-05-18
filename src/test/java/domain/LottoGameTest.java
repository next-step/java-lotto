package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoGameTest {

    @Test
    public void 로또_구입금액과_번호를_수동으로_입력하면_구입금액에_해당하는_로또를_발행한다() {
        //given
        int money = 14000;
        int[] manualLottoNumber = new int[] { 2, 4, 6, 7, 10, 12 };
        int manualCount = 1;
        LottoGame lottoGenerator = new LottoGame();
        List<int[]> manualNumbers = new ArrayList<>();
        manualNumbers.add(manualLottoNumber);
        ManualRequest manualRequest = new ManualRequest(manualCount, manualNumbers);

        //when
        lottoGenerator.generateLottoResultsFromMoney(manualRequest, money);
        LottoResults lottoResults = lottoGenerator.getLottoResults();
        List<List<Integer>> lottoResultList = lottoResults.lottoNumbersToInt();
        //then
        assertThat(lottoResultList).hasSize(14);
        for (List<Integer> lottoNum : lottoResultList) {
            assertThat(lottoNum).hasSize(6);
        }
    }



}
