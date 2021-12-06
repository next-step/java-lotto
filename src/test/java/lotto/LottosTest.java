package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottosTest {

    @Test
    void 구매_개수만큼_로또_반환() {
        Lottos lottos = new Lottos("6000");
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(6);
    }

    @Test
    void 로또_불변성_테스트() {
        Lotto lotto = Lotto.newInstance();
        List<Integer> numbers = lotto.getNumbers();
        Assertions.assertThatThrownBy(() -> numbers.add(99)).isInstanceOf(UnsupportedOperationException.class);
    }
}
