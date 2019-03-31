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
        this.lotto = new Lotto(LottoNumbers.convertToLottoNo(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void 로또_2개일치() {
        List<Integer> lottoNos = Arrays.asList(1, 10, 11, 12, 13, 14);
        WinningNumbers winningNumbers = new WinningNumbers(LottoNumbers.convertToLottoNo(lottoNos), 15);
        LottoRank lottoMatchCount = new LottoMatch(winningNumbers).matchResult(lotto);
        produceResult.putIfAbsent(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
        assertThat(produceResult.get(LottoRank.MISS)).isEqualTo(1);
    }

    @Test
    public void 로또_5개일치_보너스볼_일치() {
        List<Integer> lottoNos = Arrays.asList(1, 2, 3, 4, 5, 10);
        WinningNumbers winningNumbers = new WinningNumbers(LottoNumbers.convertToLottoNo(lottoNos), 6);
        LottoRank lottoMatchCount = new LottoMatch(winningNumbers).matchResult(lotto);
        produceResult.putIfAbsent(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
        assertThat(produceResult.get(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    public void 로또_5개일치() {
        List<Integer> lottoNos = Arrays.asList(1, 2, 3, 4, 5, 14);
        WinningNumbers winningNumbers = new WinningNumbers(LottoNumbers.convertToLottoNo(lottoNos), 15);
        LottoRank lottoMatchCount = new LottoMatch(winningNumbers).matchResult(lotto);
        produceResult.putIfAbsent(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
        assertThat(produceResult.get(LottoRank.THIRD)).isEqualTo(1);
    }
}