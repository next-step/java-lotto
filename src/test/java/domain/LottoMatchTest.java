package domain;

import org.junit.Before;
import org.junit.Test;
import util.Calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoMatchTest {
    private Map<LottoRank, Integer> produceResult = new HashMap<>();
    private Lotto lotto;

    @Before
    public void initLottoMatchTest() {
        this.lotto = new Lotto(new LottoNumbers(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6))));
    }

    @Test
    public void 로또_2개일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(10), new LottoNo(11), new LottoNo(12), new LottoNo(13), new LottoNo(14));
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(lottoNos), new LottoNo(15));
        LottoRank lottoMatchCount = new LottoMatch(winningNumbers).matchResult(lotto);
        produceResult.putIfAbsent(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
        assertThat(produceResult.get(LottoRank.MISS)).isEqualTo(1);
    }

    @Test
    public void 로또_5개일치_보너스볼_일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(10));
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(lottoNos), new LottoNo(6));
        LottoRank lottoMatchCount = new LottoMatch(winningNumbers).matchResult(lotto);
        produceResult.putIfAbsent(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
        assertThat(produceResult.get(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    public void 로또_5개일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(10));
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(lottoNos), new LottoNo(15));
        LottoRank lottoMatchCount = new LottoMatch(winningNumbers).matchResult(lotto);
        produceResult.putIfAbsent(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
        assertThat(produceResult.get(LottoRank.THIRD)).isEqualTo(1);
    }
}