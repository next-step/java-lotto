package domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualSelectRuleTest {
    @Test
    void create() {
        //given
        LottoNumbersList lottoNumbersList = TestObjectSupport.createLottoNumbersList();

        //when
        ManualSelectRule result = new ManualSelectRule(lottoNumbersList);

        //then
        assertThat(result).isEqualTo(new ManualSelectRule(lottoNumbersList));
    }

    @Test
    void select() {
        //given
        ManualSelectRule selectRule = TestObjectSupport.createManualSelectRule();
        LottoNumbers expectedResult = TestObjectSupport.createLottoNumbers();

        //when
        LottoNumbers result1 = selectRule.select();
        LottoNumbers result2 = selectRule.select();
        LottoNumbers result3 = selectRule.select();

        //then
        assertThat(result1).isEqualTo(expectedResult);
        assertThat(result2).isEqualTo(expectedResult);
        assertThat(result3).isEqualTo(expectedResult);
    }

    @Test
    void isSelectable() {
        //given
        ManualSelectRule selectableSelectRule = TestObjectSupport.createManualSelectRule();
        ManualSelectRule unselectableSelectRule = new ManualSelectRule(new LottoNumbersList(Collections.emptyList()));

        //when
        boolean result1 = selectableSelectRule.isSelectable();
        boolean result2 = unselectableSelectRule.isSelectable();

        //then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }
}
