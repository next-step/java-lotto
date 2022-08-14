package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ComplexSelectRuleTest {
    @Test
    void createByStaticFactoryMethod() {
        //given
        ManualSelectRule manualSelectRule = TestObjectSupport.createManualSelectRule();
        RandomSelectRule randomSelectRule = TestObjectSupport.createRandomSelectRule();

        //when
        ComplexSelectRule result = ComplexSelectRule.create(manualSelectRule, randomSelectRule);

        //then
        assertThat(result).isEqualTo(ComplexSelectRule.create(manualSelectRule, randomSelectRule));
    }

    @Test
    void select() {
        //given
        ComplexSelectRule complexSelectRule = TestObjectSupport.createComplexSelectRule();
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

    @Test
    void isSelectable() {
        //given
        ComplexSelectRule complexSelectRule = TestObjectSupport.createComplexSelectRule();

        //when
        boolean result = complexSelectRule.isSelectable();

        //then
        assertThat(result).isTrue();
    }
}
