package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void buy_one_lotto(){
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.sell(1000L);

        assertThat(lottos).hasSize(1);
    }

    @Test
    void buy_many_lotto(){
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.sell(5000L);

        assertThat(lottos).hasSize(5);
    }



}
