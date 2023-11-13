package src.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    void 로또와_매치하여_순위를_확인할_수_있다() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                List.of(GameNumber.of(1), GameNumber.of(2), GameNumber.of(3),
                        GameNumber.of(4), GameNumber.of(5), GameNumber.of(6))
        );

        List<GameNumber> gameNumbers = List.of(GameNumber.of(4), GameNumber.of(5), GameNumber.of(6),
                GameNumber.of(7), GameNumber.of(8), GameNumber.of(9));

        // when
        Place place = winningLotto.match(gameNumbers);

        // then
        assertThat(place).isEqualTo(Place.FOURTH_PLACE);
    }
}
