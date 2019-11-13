package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.ManualLottosGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottos lottos;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        lotto = new Lotto(numbers);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);
        this.lottos = new Lottos(()-> lottos);
    }

    @Test
    void 로또_수동_테스트() {
        List<String> manualLottos = Arrays.asList("1, 2, 3, 4, 5, 6", "10, 11, 12, 13, 14, 15", "5, 6, 7, 8, 9, 10");
        Lottos lottos = new Lottos(new ManualLottosGenerator(manualLottos));
        assertThat(lottos.getLottos()).hasSize(3);
    }
}
