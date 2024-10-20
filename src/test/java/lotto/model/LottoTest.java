package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 생성자_테스트() {
        Lotto lotto = new Lotto(Set.of(new LottoNumber(1), new LottoNumber(2),new LottoNumber(3), new LottoNumber(4),new LottoNumber(5), new LottoNumber(6)));

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
