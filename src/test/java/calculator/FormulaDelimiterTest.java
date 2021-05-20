package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FormulaDelimiterTest {

    @Test
    @DisplayName("구분자 처리")
    void split() {
        // given
        String text = "1:2,3";

        // when
        String[] formula = FormulaDelimiter.split(text);

        // then
        assertThat(formula).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("단일 문자에 대한 구분처리")
    void split_singleText() {
        // given
        String text = "1";

        // when
        String[] formula = FormulaDelimiter.split(text);

        // then
        assertThat(formula).isEqualTo(new String[]{"1"});
    }

    @Test
    @DisplayName("구분자와 다른 문자가 섞여있는 경우")
    void split_hasOtherText() {
        // given
        String text = "1,2:3/4";

        // when
        String[] formula = FormulaDelimiter.split(text);

        // then
        assertThat(formula).isEqualTo(new String[]{"1", "2", "3/4"});
    }
}