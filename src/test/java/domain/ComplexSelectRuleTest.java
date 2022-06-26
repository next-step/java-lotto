package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ComplexSelectRuleTest {
    @Test
    void create() {
        //given
        LottoNumbersList lottoNumbersList = TestObjectSupport.createLottoNumbersList();
        SelectRule selectRule = TestObjectSupport.createSelectRule();

        //when
        ComplexSelectRule result = new ComplexSelectRule(lottoNumbersList, selectRule);

        //then
        assertThat(result).isEqualTo(new ComplexSelectRule(lottoNumbersList, selectRule));
    }

    @Test
    void select() {
        //given
        ComplexSelectRule complexSelectRule = TestObjectSupport.createManualSelectRule();
        LottoNumbers expectedManualLottoNumbers = TestObjectSupport.createLottoNumbers();
        LottoNumbers expectedNonManualLottoNumbers = LottoNumbers.create(Arrays.asList(7, 8, 9, 10, 11, 12));

        //when
        LottoNumbers result1 = complexSelectRule.select();
        LottoNumbers result2 = complexSelectRule.select();
        LottoNumbers result3 = complexSelectRule.select();
        LottoNumbers result4 = complexSelectRule.select();

        //then
        assertThat(result1).isEqualTo(expectedManualLottoNumbers);
        assertThat(result2).isEqualTo(expectedManualLottoNumbers);
        assertThat(result3).isEqualTo(expectedManualLottoNumbers);
        assertThat(result4).isEqualTo(expectedNonManualLottoNumbers);
    }
}
