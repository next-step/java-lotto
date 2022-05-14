package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomSelectRuleTest {
    @Test
    void pick() {
        //given
        RandomSelectRule selectRule = new RandomSelectRule();

        //when
        LottoNumbers result = selectRule.select();

        //then
        assertThat(result).isNotNull();
    }
}
