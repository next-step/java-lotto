package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottosTest {

    @Test
    @DisplayName("로또's 생성 테스트")
    void generateLottosTest() {
        List<Lotto> lottoList = Arrays.asList(
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        Lottos lottos = new Lottos(lottoList);
    }
}
