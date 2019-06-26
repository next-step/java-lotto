package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("로또들을 추가")
    public void created() {
        Lottos lottos = new Lottos();
        PickNumbers pickNumbers = new PickNumbers(
                Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)
                )
        );
        lottos.add(pickNumbers);
        assertThat(lottos.getPickNumbers().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("합치기")
    public void merge() {
        Lottos lottos1 = new Lottos();

        lottos1.add(new PickNumbers(
                Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)
                )
        ));

        Lottos lottos2 = new Lottos();

        lottos2.add(new PickNumbers(
                Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)
                )
        ));

        lottos1.merge(lottos2);
        assertThat(lottos1.getPickNumbers().size()).isEqualTo(2);
    }

}