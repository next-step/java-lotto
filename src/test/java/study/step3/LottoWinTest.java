package study.step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
