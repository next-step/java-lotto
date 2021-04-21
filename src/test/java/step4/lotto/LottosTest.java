package step4.lotto;

import org.junit.jupiter.api.Test;
import step4.lotto.domain.Lotto;
import step4.lotto.domain.Lottos;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {
    @Test
    void init() {
        Lottos lottos = new Lottos();
        assertThat(lottos).isEqualTo(new Lottos());
    }

    @Test
    void 로또_2개_추가() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        assertThat(lottos.lottoCount()).isEqualTo(2);
    }


    @Test
    void 로또_수동_2개_추가() {
        List<String> lottoList = Arrays.asList("1,2,3,4,5,6", "4,5,6,7,8,9");
        Lottos lottos = new Lottos();
        lottos.addLotto(lottoList);
        assertThat(lottos.lottoCount()).isEqualTo(2);
    }

    @Test
    void 로또_수동_2개_유효성검사() {
        List<String> lottoList = Arrays.asList("2,3,4,5,6", "444,5,6,7,8,9");
        Lottos lottos = new Lottos();
        assertThatThrownBy(() -> {
            lottos.addLotto(lottoList);
       }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_자동_3개() {
        Lottos lottos = new Lottos();
        lottos.addLotto(3);
        assertThat(lottos.lottoCount()).isEqualTo(3);
    }

    @Test
    void display() {
        Lottos lottos = new Lottos();
        lottos.addLotto(3);
        System.out.println(lottos.toString());

    }
}
