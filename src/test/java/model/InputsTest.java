package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class InputsTest {

    @Test
    void 수동으로_입력받은_인풋을_로또_리스트로_변환한다() {
        // given
        final Inputs inputs = new Inputs(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(3, 4, 5, 6, 7, 8)));

        // when
        final List<Lotto> lottos = inputs.createLottos();

        // then
        assertThat(lottos).hasSize(2);
    }
}
