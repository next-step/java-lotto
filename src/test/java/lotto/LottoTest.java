package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_한_장의_가격은_1000원이다(){
        Lotto lotto = new Lotto();
        assertThat(lotto.PRICE).isEqualTo(1000);
    }
}
