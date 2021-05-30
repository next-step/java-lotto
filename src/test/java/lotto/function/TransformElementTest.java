package lotto.function;

import lotto.domain.LottoNumberText;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TransformElementTest {

    @Test
    void apply() {
        // given
        List<LottoNumberText> lottoNumberTextList = Arrays.asList(new LottoNumberText("1,2,3,4,5,6"), new LottoNumberText("11,12,13,14,15,16"));
        String[] expected = new String[]{"1,2,3,4,5,6", "11,12,13,14,15,16"};

        // when
        List<String> strings = new TransformElement<LottoNumberText, String>().apply(lottoNumberTextList, LottoNumberText::text);

        // then
        assertThat(strings).containsExactly(expected);
    }
}
