package lotto.model;

import lotto.strategy.NumberGenerateStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 생성자_테스트() {
        Lotto lotto = new Lotto(Set.of(new Number(1), new Number(2),new Number(3), new Number(4),new Number(5), new Number(6)));

        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }

    @Test
    void 생성자_예외() {
        assertThatThrownBy(() -> {
            new Lotto(1, 2, 3, 4, 5);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Lotto(1, 2, 3, 4, 5, 6, 7);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
