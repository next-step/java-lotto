package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @DisplayName("텍스트를 ,를 기준으로 나눌 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void testMoneyPerLottoCount(final String inputText) {
        assertThat(Parser.splitToNumbers(inputText)).hasSize(6);
    }
}
