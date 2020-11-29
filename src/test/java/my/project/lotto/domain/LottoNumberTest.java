package my.project.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created : 2020-11-27 오후 2:38
 * Developer : Seo
 */
class LottoNumberTest {
    @Test
    void generate() {
        assertThat(LottoGenerator.generate()).isInstanceOf(Lotto.class);
    }

}