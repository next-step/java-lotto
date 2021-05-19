package lotto.util;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TextParserTest {

    @DisplayName("텍스트를 ,를 기준으로 나눌 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,15,20,25,30,45"})
    void testMoneyPerLottoCount(final String inputText) {
        List<LottoNumber> lottoNumbers = TextParser.parseToLottoNumbers(inputText);
        assertThat(lottoNumbers).hasSize(6);
    }
}
