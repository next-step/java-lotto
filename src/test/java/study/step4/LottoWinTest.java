package study.step4;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study.step4.domain.LottoMoney;
import study.step4.domain.LottoWin;

public class LottoWinTest {
    @ParameterizedTest(name = "합계 테스트")
    @CsvSource(value = {"3,4,5,6:2001555000", "3,3,3:15000"}, delimiter = ':')
    public void sum(String inputs, String expected) {
        // gieven
        LottoWin lottoWin = new LottoWin();
        String[] hits = inputs.split(",");
        for(String hit : hits) {
            lottoWin.hit(Integer.parseInt(hit));
        }
        // when & then
        assertThat(lottoWin.sum()).isEqualTo(Integer.parseInt(expected));
    }

    @ParameterizedTest(name = "수익 테스트")
    @CsvSource(value = {"3,4,5:1555.00", "3,3,3:15.00"}, delimiter = ':')
    public void profit(String inputs, String expected) {
        // given
        LottoWin lottoWin = new LottoWin();
        String[] hits = inputs.split(",");
        for(String hit : hits) {
            lottoWin.hit(Integer.parseInt(hit), false);
        }
        // when & then
        assertThat(lottoWin.profit(new LottoMoney(1000))).isEqualTo(expected);
    }

    @ParameterizedTest(name = "보너스 수익 테스트")
    @CsvSource(value = {"3,4,5:30055.00", "3,3,5:30010.00"}, delimiter = ':')
    public void profitWithBonus(String inputs, String expected) {
        // given
        LottoWin lottoWin = new LottoWin();
        String[] hits = inputs.split(",");
        for(String hit : hits) {
            lottoWin.hit(Integer.parseInt(hit), true);
        }
        // when & then
        assertThat(lottoWin.profit(new LottoMoney(1000))).isEqualTo(expected);
    }
}
