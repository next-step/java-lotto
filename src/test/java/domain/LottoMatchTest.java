package domain;

import org.junit.Before;
import org.junit.Test;
import util.Calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoMatchTest {
    private Map<LottoRank, Integer> produceResult = new HashMap<>();
    private Lotto lotto;

    @Before
    public void initLottoMatchTest() {
        this.lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void 로또_2개일치() {
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(Arrays.asList(1, 10, 11, 12, 13, 14)), 15);
        LottoRank lottoMatchCount = new LottoMatch(winningNumbers).matchResult(lotto);
        produceResult.putIfAbsent(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
        assertThat(produceResult.get(LottoRank.MISS)).isEqualTo(1);
    }

    @Test
    public void 로또_5개일치_보너스볼_일치() {
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 10)), 6);
        LottoRank lottoMatchCount = new LottoMatch(winningNumbers).matchResult(lotto);
        produceResult.putIfAbsent(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
        assertThat(produceResult.get(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    public void 로또_5개일치() {
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 10)), 15);
        LottoRank lottoMatchCount = new LottoMatch(winningNumbers).matchResult(lotto);
        produceResult.putIfAbsent(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
        assertThat(produceResult.get(LottoRank.THIRD)).isEqualTo(1);
    }
}