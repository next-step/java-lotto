package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.generator.FixedNumbersGenerator;
import org.junit.jupiter.api.Test;

class AutoLottosTest {

    @Test
    void 자동_로또_컬렉션_리스트받아서_객체_생성시_정상적으로_데이터_담기_성공() {
        // given, when
        AutoLottos lottos = new AutoLottos(2, new FixedNumbersGenerator(List.of(1, 2, 3, 4, 5, 6)));

        // then
        assertThat(lottos.getLottos()).isEqualTo(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        ));

    }
}
