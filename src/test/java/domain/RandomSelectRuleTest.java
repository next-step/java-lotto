package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomSelectRuleTest {
    @Test
    void select() {
        //given
        RandomSelectRule selectRule = new RandomSelectRule();

        //when
        LottoNumbers result = selectRule.select();

        //then
        assertThat(result).isNotNull();
    }

    @Test
    void isSelectable() {
        //given
        RandomSelectRule selectRule = new RandomSelectRule();

        //when
        boolean result = selectRule.isSelectable();

        //then
        assertThat(result).isTrue();
    }
}
