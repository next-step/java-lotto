package lottoauto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class LottosTest {
    Lottos lottos;

    @Test
    void lotto_generate_test(){
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(2,3,4,5,6,7));
        List<Lotto> list = new ArrayList<>();
        list.add(lotto1);
        list.add(lotto2);

        lottos = new Lottos(list);
        lottos.checkWinningLotto(new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 4));

        assertThat(lottos.all().size()).isEqualTo(2);
    }
}