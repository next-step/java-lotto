package lotto.service;

import lotto.dto.Lotto;
import lotto.dto.WinningLotto;
import lotto.utils.MatchUtils;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResultTest {

    private WinningLotto wl;

    @Before
    public void Winner세팅() {
        wl = new WinningLotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)),7);
    }


    @Test
    public void 손해결과출력() {
        LottoResult lr = new LottoResult(new ArrayList<Lotto>(Arrays.asList(new Lotto())),wl,14000);
        assertThat(lr.getProfitMessage(0.5f)).isEqualTo(LottoResult.MINUS_PROFIT);
    }

    @Test
    public void 이익결과출력() {
        LottoResult lr = new LottoResult(new ArrayList<Lotto>(Arrays.asList(new Lotto())),wl,14000);
        assertThat(lr.getProfitMessage(1.5f)).isEqualTo(LottoResult.PLUS_PROFIT);
    }

    @Test
    public void 본전결과출력() {
        LottoResult lr = new LottoResult(new ArrayList<Lotto>(Arrays.asList(new Lotto())),wl,14000);
        assertThat(lr.getProfitMessage(1)).isEqualTo(LottoResult.SAME_PROFIT);
    }

    @Test
    public void 출력값정상테스트() {

        LottoResult lr = new LottoResult(new ArrayList<Lotto>(Arrays.asList(new Lotto())),wl,14000);
        String result = "6개 일치 (2000000000원) - 0개\n" +
                        "5개 일치, 보너스 볼 일치 (30000000원) - 0개\n" +
                        "5개 일치 (1500000원) - 0개\n" +
                        "4개 일치 (50000원) - 0개\n" +
                        "3개 일치 (5000원) - 0개\n" +
                        "0개 일치 (0원) - 0개\n" +
                        "총 수익률은 0.00입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

        assertThat(lr.matchCountResultString(lr.getWinnerNums())).isEqualTo(result);

    }

    @Test
    public void 결과값정상테스트() {

        LottoResult lr = new LottoResult(new ArrayList<Lotto>(Arrays.asList(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,7))))), wl, 14000);
        String result = "6개 일치 (2000000000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30000000원) - 0개\n" +
                "5개 일치 (1500000원) - 1개\n" +
                "4개 일치 (50000원) - 0개\n" +
                "3개 일치 (5000원) - 0개\n" +
                "0개 일치 (0원) - 0개\n" +
                "총 수익률은 107.00입니다. (기준이 1이기 때문에 결과적으로 이익라는 의미임)";

        assertThat(lr.matchCountResultString(lr.getWinnerNums())).isEqualTo(result);
    }
}
