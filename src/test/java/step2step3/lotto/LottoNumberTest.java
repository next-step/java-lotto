package step2step3.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @Test
    void 로또_숫자가_같으면_서로_동일한_객체다() {
        assertThat(new LottoNumber(5)).isEqualTo(new LottoNumber(5));
    }
}
