package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class LottoGameTest {

    @Test
    public void 로또_구입금액과_번호를_수동으로_입력하면_구입금액에_해당하는_로또를_발행한다() {
        //given
        int money = 14000;
        Set<Integer> manualLottoNumber = new HashSet<>();
        manualLottoNumber.add(2);
        manualLottoNumber.add(4);
        manualLottoNumber.add(6);
        manualLottoNumber.add(7);
        manualLottoNumber.add(10);
        manualLottoNumber.add(12);

        int manualCount = 1;
        LottoGame lottoGenerator = new LottoGame();
        List<Set<Integer>> manualNumbers = new ArrayList<>();
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

//    @Test
//    public void 로또_번호를_수동으로_입력할_때_중복된_번호를_입력하면_예외를_던진다() {
//        //given
//        int money = 1000;
//        List<Integer> manualLottoNumber = Arrays.asList(2, 2, 6, 7, 10, 12);
//        int manualCount = 1;
//        LottoGame lottoGenerator = new LottoGame();
//        List<List<Integer>> manualNumbers = new ArrayList<>();
//        manualNumbers.add(manualLottoNumber);
//        ManualRequest manualRequest = new ManualRequest(manualCount, manualNumbers);
//
//        //when
//
//
//        //then
//
//    }



}
