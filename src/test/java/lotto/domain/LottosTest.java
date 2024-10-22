package lotto.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.as;

class LottosTest {

    @DisplayName("여러 개의 Lotto들을 조합하여 하나의 Lottos 객체를 생성한다.")
    @Test
    void create() {
        List<Lotto> given = new ArrayList<>();
        given.add(new Lotto(1, 2, 3, 4, 5, 6));

        Lottos actual = new Lottos(given);

        assertThat(actual).extracting("lottos", as(InstanceOfAssertFactories.LIST))
                .contains(new Lotto(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("여러개의 Lottos 객체들을 조합하여 하나의 Lottos 객체를 생성한다.")
    @Test
    void create_from_multiple_Lottos() {
        Lottos lottos1 = new Lottos(new Lotto(1, 2, 3, 4, 5, 6));
        Lottos lottos2 = new Lottos(new Lotto(40, 41, 42, 43, 44, 45));
        Lottos actual = Lottos.from(lottos1, lottos2);

        assertThat(actual).extracting("lottos", as(InstanceOfAssertFactories.LIST))
                .containsExactlyInAnyOrder(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(40, 41, 42, 43, 44, 45));
    }
}
