package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void 로또정상발급확인() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
        for(Integer number : lotto.getNumbers()){
            assertThat(LottoRule.NUMBER_RANGE.contains(number)).isTrue();
        }
    }
}
