package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    PlayLotto playLotto = new PlayLotto();
    @Test
    @DisplayName("금액에 따른 로또 생성")
    void lottoCountTest(){
        int cash = 14000;
        List<Lotto> lottos = playLotto.createLotto(cash);
        assertThat(lottos.size()).isEqualTo(14);
    }
}
