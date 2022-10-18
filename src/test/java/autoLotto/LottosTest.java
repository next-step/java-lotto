package autoLotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    @Test
    void lotto() {
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto());

        assertThat(lottos.getLottosSize()).isEqualTo(1);
    }

    @Test
    void matchQuantity() {
        Lotto lotto = new Lotto(new Integer[]{1, 2, 3, 4, 5, 6});
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(6);
        numbers.add(5);
        numbers.add(45);
        numbers.add(10);
        numbers.add(11);

        assertThat(lotto.getMatchQuantity(numbers)).isEqualTo(3);

    }
}
