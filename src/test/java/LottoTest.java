import domain.Lotto;
import domain.LottoNumber;
import domain.MatchCount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {


    @Test
    void 자동_생성_로또는_중복없는_6개_번호를_오름차순으로_가진다() {
        Lotto lotto = new Lotto();

        List<Integer> values = lotto.getNumbers().stream()
                .map(LottoNumber::getValue)
                .toList();

        assertThat(values)
                .hasSize(6)
                .doesNotHaveDuplicates()
                .isSorted();
    }

    @Test
    void 자동_생성된_번호는_모두_1부터_45_사이다() {
        Lotto lotto = new Lotto();

        assertThat(lotto.getNumbers())
                .allMatch(n -> n.getValue() >= LottoNumber.MIN && n.getValue() <= LottoNumber.MAX);
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 번호가_6개가_아니면_예외가_발생한다(String numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호에_중복이_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 문자열을_콤마로_분리해_생성한다() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");

        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 받은_번호를_그대로_보관한다() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto.getNumbers())
                .containsExactly(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
                );
    }

    @Test
    void 특정_번호_포함_여부를_반환한다() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto.contains(new LottoNumber(1))).isTrue();
        assertThat(lotto.contains(new LottoNumber(7))).isFalse();
    }

    @Test
    void 당첨_번호와_일치하는_개수를_반환한다() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(1, 2, 3, 10, 11, 12);

        assertThat(lotto.match(winningLotto)).isEqualTo(new MatchCount(3));
    }
}