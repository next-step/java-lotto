package lotto.service;

import lotto.dto.Lotto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResultTest {

    @Test
    public void 중복갯수출력() {
        List<Integer> lotto1 = new ArrayList<>(Arrays.asList(11,12,13,15,16,17));
        List<Integer> lotto2 = new ArrayList<>(Arrays.asList(1,2,3,15,16,17));

        int nums = LottoResult.duplicatedCounts(lotto1,lotto2);
        assertThat(nums).isEqualTo(3);
    }

    @Test
    public void 손해결과출력() {
        LottoResult lr = new LottoResult(new ArrayList<Lotto>(Arrays.asList(new Lotto())),new ArrayList<>(Arrays.asList(1,2,3,4,5,6)),14000);
        assertThat(lr.getProfitMessage(0.5f)).isEqualTo(LottoResult.MINUS_PROFIT);
    }

    @Test
    public void 이익결과출력() {
        LottoResult lr = new LottoResult(new ArrayList<Lotto>(Arrays.asList(new Lotto())),new ArrayList<>(Arrays.asList(1,2,3,4,5,6)),14000);
        assertThat(lr.getProfitMessage(1.5f)).isEqualTo(LottoResult.PLUS_PROFIT);
    }

    @Test
    public void 본전결과출력() {
        LottoResult lr = new LottoResult(new ArrayList<Lotto>(Arrays.asList(new Lotto())),new ArrayList<>(Arrays.asList(1,2,3,4,5,6)),14000);
        assertThat(lr.getProfitMessage(1)).isEqualTo(LottoResult.SAME_PROFIT);
    }

    @Test
    public void 출력값정상테스트() {

        LottoResult lr = new LottoResult(new ArrayList<Lotto>(Arrays.asList(new Lotto())),new ArrayList<>(Arrays.asList(1,2,3,4,5,6)),14000);
        String result = "3개 일치 (5000원) - 0개\n" +
                "4개 일치 (50000원) - 0개\n" +
                "5개 일치 (1500000원) - 0개\n" +
                "6개 일치 (2000000000원) - 0개\n"+
                "총 수익률은 0.00입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

        assertThat(lr.matchCountResultString(lr.getWinnerNums())).isEqualTo(result);

    }
}
