package domain;

import org.junit.jupiter.api.Test;

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
        ManualSelectRule manualSelectRule = TestObjectSupport.createManualSelectRule();
        LottoNumbers expectedLottoNumbers = TestObjectSupport.createLottoNumbers();

        //when
        LottoNumbers result1 = manualSelectRule.select();
        LottoNumbers result2 = manualSelectRule.select();
        LottoNumbers result3 = manualSelectRule.select();
        LottoNumbers result4 = manualSelectRule.select();

        //then
        assertThat(result1).isEqualTo(expectedLottoNumbers);
        assertThat(result2).isEqualTo(expectedLottoNumbers);
        assertThat(result3).isEqualTo(expectedLottoNumbers);
        assertThat(result4).isNotNull();
    }
}
