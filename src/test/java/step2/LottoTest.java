package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void create() {
        Lotto lotto = new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    void 숫자가_6개가_아닌_로또() {
        assertThatThrownBy(() -> new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        )))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또의 숫자가 6개가 아닙니다.");
    }

    @Test
    void 숫자가_중복이_있는_로또() {
        assertThatThrownBy(() -> new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(1),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        )))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또의 숫자가 중복입니다.");
    }

    @Test
    void 로또값은_오름차순으로_정렬() {
        Lotto lotto = new Lotto(List.of(
                new LottoNumber(6),
                new LottoNumber(5),
                new LottoNumber(4),
                new LottoNumber(3),
                new LottoNumber(2),
                new LottoNumber(1)
        ));

        assertThat(lotto.getLottoNumbers()).containsExactly(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }

}
