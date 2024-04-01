package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void create() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(new Lottos(lottoList)).isEqualTo(new Lottos(lottoList));
    }
}
