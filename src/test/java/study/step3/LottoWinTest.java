package study.step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.step3.domain.Amount;
import study.step3.domain.LottoWin;

public class LottoWinTest {
    @ParameterizedTest(name = "합계 테스트")
    @CsvSource(value = {"3,4,5,6:2001555000", "3,3,3:15000"}, delimiter = ':')
    public void sum(String inputs, String expected) {
        LottoWin lottoWin = new LottoWin();
        String[] hits = inputs.split(",");
        for(String hit : hits) {
            lottoWin.hit(Integer.parseInt(hit));
        }
        assertThat(lottoWin.sum()).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest(name = "수익 테스트")
    @CsvSource(value = {"3,4,5:1555", "3,3,3:15"}, delimiter = ':')
    public void profit(String inputs, String expected) {
        LottoWin lottoWin = new LottoWin();
        String[] hits = inputs.split(",");
        for(String hit : hits) {
            lottoWin.hit(Integer.parseInt(hit), false);
        }
        assertThat(lottoWin.profit(new Amount(1000))).isEqualTo(expected);
    }

    @ParameterizedTest(name = "보너스 수익 테스트")
    @CsvSource(value = {"3,4,5:30055", "3,3,5:30010"}, delimiter = ':')
    public void profitWithBonus(String inputs, String expected) {
        LottoWin lottoWin = new LottoWin();
        String[] hits = inputs.split(",");
        for(String hit : hits) {
            lottoWin.hit(Integer.parseInt(hit), true);
        }
        assertThat(lottoWin.profit(new Amount(1000))).isEqualTo(expected);
    }
}
