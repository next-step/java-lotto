package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMakerTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void makeLottoTest() {
        assertThat(LottoMaker.run()).isInstanceOf(Lotto.class);
    }

}