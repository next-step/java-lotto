package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    void 같은_갯수() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        Lotto lotto0 = Lotto.of(List.of(11, 12, 13, 14, 15, 16));
        Lotto lotto1 = Lotto.of(List.of(1, 12, 13, 14, 15, 16));
        Lotto lotto2 = Lotto.of(List.of(1, 2, 13, 14, 15, 16));
        Lotto lotto3 = Lotto.of(List.of(1, 2, 3, 14, 15, 16));
        Lotto lotto4 = Lotto.of(List.of(1, 2, 3, 4, 15, 16));
        Lotto lotto5 = Lotto.of(List.of(1, 2, 3, 4, 5, 16));
        Lotto lotto6 = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.getMatchCount(lotto0)).isEqualTo(0);
        assertThat(lotto.getMatchCount(lotto1)).isEqualTo(1);
        assertThat(lotto.getMatchCount(lotto2)).isEqualTo(2);
        assertThat(lotto.getMatchCount(lotto3)).isEqualTo(3);
        assertThat(lotto.getMatchCount(lotto4)).isEqualTo(4);
        assertThat(lotto.getMatchCount(lotto5)).isEqualTo(5);
        assertThat(lotto.getMatchCount(lotto6)).isEqualTo(6);    }
}
