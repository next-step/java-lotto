package my.project.lotto.domain;

import org.junit.jupiter.api.Test;

/**
 * Created : 2020-11-27 오후 2:38
 * Developer : Seo
 */
class LottoNumberTest {
    @Test
    void generate() {
        Lotto lotto = LottoNumber.generate();
        System.out.println(lotto.toString());
    }
}