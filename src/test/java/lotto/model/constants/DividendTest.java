package lotto.model.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class DividendTest {
    @Test
    @DisplayName("맞춰야하는 숫자가 3~6사이 값이 아니면 MISS이다")
    void test1() throws Exception {
        assertThat(Dividend.valueOf(8,false))
                .isEqualTo(Dividend.MISS);
    }

    @ParameterizedTest
    @DisplayName("맞춘 숫자에 해당하는 올바른 배당금을 리턴한다")
    @CsvSource({"6,2_000_000_000", "5,1_500_000", "4,50000", "3,5000"})
    void test2(int correctCount, long dividendAmount) throws Exception {
        Dividend dividend = Dividend.valueOf(correctCount, false);
        assertThat(dividend.dividendAmount()).isEqualTo(dividendAmount);
    }

    @Test
    @DisplayName("2등은 보너스숫자 하나, 당첨숫자 5개를 맞춰야한다.")
    void test3() throws Exception {
        Dividend dividend = Dividend.valueOf(5, true);
        assertThat(dividend).isEqualTo(Dividend.SECOND);
    }
}