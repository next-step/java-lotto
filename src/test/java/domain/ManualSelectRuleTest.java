package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualSelectRuleTest {
    @Test
    void create() {
        //given
        LottoNumbersList lottoNumbersList = TestObjectSupport.createLottoNumbersList();
        SelectRule selectRule = TestObjectSupport.createSelectRule();

        //when
        ManualSelectRule result = new ManualSelectRule(lottoNumbersList, selectRule);

        //then
        assertThat(result).isEqualTo(new ManualSelectRule(lottoNumbersList, selectRule));
    }

    @Test
    void select() {
        //given
        ManualSelectRule manualSelectRule = TestObjectSupport.createManualSelectRule();
        LottoNumbers expectedManualLottoNumbers = TestObjectSupport.createLottoNumbers();
        LottoNumbers expectedNonManualLottoNumbers = LottoNumbers.create(Arrays.asList(7, 8, 9, 10, 11, 12));

        //when
        LottoNumbers result1 = manualSelectRule.select();
        LottoNumbers result2 = manualSelectRule.select();
        LottoNumbers result3 = manualSelectRule.select();
        LottoNumbers result4 = manualSelectRule.select();

        //then
        assertThat(result1).isEqualTo(expectedManualLottoNumbers);
        assertThat(result2).isEqualTo(expectedManualLottoNumbers);
        assertThat(result3).isEqualTo(expectedManualLottoNumbers);
        assertThat(result4).isEqualTo(expectedNonManualLottoNumbers);
    }
}
