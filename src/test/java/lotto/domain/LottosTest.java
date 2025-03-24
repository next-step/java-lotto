package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 당첨_개수() {
        Lottos lottos = new Lottos(
            List.of(
                    new Lotto(List.of(1,2,3,4,5,6)),
                    new Lotto(List.of(4,5,6,7,8,9))
            )
        );
        assertThat(lottos.getMatchNums(new Lotto(List.of(4,5,6,11,12,13)))).isEqualTo(Map.of(3, 2));
    }
}
