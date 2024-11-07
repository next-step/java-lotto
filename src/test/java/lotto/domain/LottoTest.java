package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 로또_생성() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        assertThat(lotto).isEqualTo(new Lotto("1, 2, 3, 4, 5, 6"));
    }

    @Test
    void 로또_6자리_검증() {
        assertThatThrownBy(() -> {
            new Lotto(1, 2, 3, 4, 5, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_오름차순_정렬() {
        Lotto lotto = new Lotto(6, 5, 4, 3, 2, 1);
        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }
}
