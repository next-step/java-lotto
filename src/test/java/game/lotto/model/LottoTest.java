package game.lotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또_생성() {
        Lotto lotto = new Lotto();

        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }


}