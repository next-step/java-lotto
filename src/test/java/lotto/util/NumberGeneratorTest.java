package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    void 자동_로또_생성() {
        assertThat(NumberGenerator.makeAutoLotto().getLotto().size()).isEqualTo(6);
    }

    @RepeatedTest(100)
    void 랜덤_숫자를_잘_획득하는지_확인() {
        NumberGenerator.makeAutoLotto();

        Lotto lotto = new Lotto();

        for (LottoNumber lottoNumber : lotto.getLotto()) {
            assertThat(lottoNumber.getLottoNumber()).isBetween(1, 45);
        }
    }
}
