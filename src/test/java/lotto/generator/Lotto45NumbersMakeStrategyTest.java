package lotto.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Lotto45NumbersMakeStrategyTest {

    @Test
    @DisplayName("45개 번호에서 로또 번호 6개의 수를 만든다")
    void make_till_45() {
        LottoNumbersMakeStrategy generator = new Lotto45NumbersMakeStrategy();
        assertThat(generator.makeLottoNumber().size()).isEqualTo(6);
    }



}