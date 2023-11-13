package src.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void 로또와_매치하여_순위를_확인할_수_있다() {
        // given
        Lotto gameLotto = new Lotto(
                Set.of(GameNumber.of(1), GameNumber.of(2), GameNumber.of(3),
                        GameNumber.of(4), GameNumber.of(5), GameNumber.of(6))
        );

        Lotto winningLotto = new Lotto(Set.of(GameNumber.of(4), GameNumber.of(5), GameNumber.of(6),
                GameNumber.of(7), GameNumber.of(8), GameNumber.of(9)));

        // when
        Place place = gameLotto.match(winningLotto);

        // then
        assertThat(place).isEqualTo(Place.FOURTH_PLACE);
    }
}
