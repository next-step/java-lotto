package step4.lotto;

import org.junit.jupiter.api.Test;
import step4.lotto.domain.Lottos;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @Test
    void 로또_수동_2개_추가() {
        List<String> lottoList = Arrays.asList("1,2,3,4,5,6", "4,5,6,7,8,9");
        Lottos lottos = new Lottos(lottoList, 0);
        assertThat(lottos.lottoSize()).isEqualTo(2);
    }

    @Test
    void 로또_수동_2개_유효성검사() {
        List<String> lottoList = Arrays.asList("2,3,4,5,6", "444,5,6,7,8,9");
        assertThatThrownBy(() -> {
            new Lottos(lottoList, 0);
       }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_자동_3개() {
        Lottos lottos = new Lottos(null, 3);
        assertThat(lottos.lottoSize()).isEqualTo(3);
    }
}
