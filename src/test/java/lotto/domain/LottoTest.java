package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또를 생성하면 번호가 6개인 로또가 생성된다")
    @Test
    void create() {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());

        // when
        int lottoSize = lotto.getLotto().size();

        // then
        assertThat(lottoSize).isEqualTo(Lotto.NUMBER_SIZE);
    }
}
