package lotto.model.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class DividendTest {
    @Test
    @DisplayName("맞춰야하는 숫자가 3~6사이 값이 아니면 에러")
    void test1() throws Exception {
        assertThatThrownBy(() -> Dividend.getDividend(8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("맞춘 숫자에 해당하는 올바른 배당금을 리턴한다")
    @CsvSource({"6,2_000_000_000", "5,1_500_000", "4,50000", "3,5000"})
    void test2(int correctCount, long dividendAmount) throws Exception {
        Dividend dividend = Dividend.getDividend(correctCount);
        assertThat(dividend.dividendAmount()).isEqualTo(dividendAmount);
    }
}