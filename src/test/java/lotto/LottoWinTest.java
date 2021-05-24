package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.LottoWin;
import lotto.domain.Money;

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

    @ParameterizedTest(name = "보너스 합계 테스트")
    @CsvSource(value = {"3,4,5,6:2030055000", "3,3,3:15000"}, delimiter = ':')
    public void sumWithBonus(String inputs, String expected) {
        LottoWin lottoWin = new LottoWin();
        String[] hits = inputs.split(",");
        for(String hit : hits) {
            lottoWin.hit(Integer.parseInt(hit), true);
        }
        assertThat(lottoWin.sum()).isEqualTo(Integer.parseInt(expected));
    }

    @Test
    @DisplayName("수익 테스트")
    public void profit() {
        // given
        LottoWin lottoWin = new LottoWin();
        String[] hits = "3,4,5".split(",");
        for(String hit : hits) {
            lottoWin.hit(Integer.parseInt(hit), false);
        }
        // when & then
        assertThat(lottoWin.profit(new Money(1000))).isEqualTo("1555.00");
    }

    @Test
    @DisplayName("보너스 수익 테스트")
    public void profitWithBonus() {
        // given
        LottoWin lottoWin = new LottoWin();
        String[] hits = "3,4,5".split(",");
        for(String hit : hits) {
            lottoWin.hit(Integer.parseInt(hit), true);
        }
        // when & then
        assertThat(lottoWin.profit(new Money(1000))).isEqualTo("30055.00");
    }
}
