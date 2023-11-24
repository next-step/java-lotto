package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.utility.NumberSplitter;

class LottoNumberSplitterTest {

    @Test
    @DisplayName("입력한 당첨 번호 문자열을 Set으로 변경한다.")
    void splitNumbers() {
        String inputNumbers = "1, 2, 3, 4, 5, 6";
        assertThat(NumberSplitter.splitNumber(inputNumbers)).hasSize(6);
    }

}
