package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    @Test
    @DisplayName("로또 생성")
    void create() {
        Lottos lottos = new Lottos(2, new LottoCreatingRandomStrategy(){
            @Override
            public Lotto create() {
                return new Lotto("1, 2, 3, 4, 5, 6");
            }
        });

        assertThat(lottos.getLottos()).containsExactlyElementsOf(Arrays.asList(new Lotto("1, 2, 3, 4, 5, 6"), new Lotto("1, 2, 3, 4, 5, 6")));
    }

    @Test
    @DisplayName("일치 숫자 비교")
    void match() {
        Lottos lottos = new Lottos(2, new LottoCreatingRandomStrategy(){
            @Override
            public Lotto create() {
                return new Lotto("1, 2, 3, 4, 5, 6");
            }
        });

        Lotto lotto = new Lotto("1, 2, 3, 7, 8, 9");
        assertThat(lottos.matchesLottos(lotto)).containsExactly(3, 3);
    }
}
