package lottogame.model.util;


import static lottogame.model.lotto.LottoMachine.DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    void 입력받은_로또문자열을_구분자에맞게_나누고_정수형으로_변환할_수_있다() {
        assertThat(
                StringUtils.splitAndParseToInt("1, 2, 3, 4, 5, 6", DELIMITER)
        ).contains(1, 2, 3, 4, 5, 6);
    }
}