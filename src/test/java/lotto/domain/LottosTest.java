package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class LottosTest {
    @DisplayName("로또 리스트 (로또 여러 개) 생성 테스트")
    @Test
    void create_lotto_list () {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1)),
                        new Lotto(Arrays.asList(35, 23, 5, 9, 3, 8))
                )
        );
        assertThat(lottos)
                .extracting("lottos")
                .asList()
                .hasSize(2);

        assertThat(lottos)
                .extracting("lottos")
                .asList()
                .containsExactly(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(3, 5, 8, 9, 23, 35))
                );

    }

    @DisplayName("로또 여러 개 비교 후 순위 개수 리스트 생성 테스트")
    @Test
    void compare_lottos () {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1)),
                        new Lotto(Arrays.asList(35, 23, 5, 9, 3, 8))
                )
        );
        assertThat(lottos.compareNumbers(new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1))))
                .contains(entry(Division.FIRST, 1));

    }
}
