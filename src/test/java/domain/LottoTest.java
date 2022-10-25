package domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 로또는_서로다른_여섯개의_숫자를_가진다() {
        List<Lotto> lottos = LottoGenerator.getInstance().generateLotto(new Price(10000));
        assertThat(lottos)
                .allMatch(lotto -> new HashSet<>(lotto.getLottoNumbers()).size() == 6);
    }

    @Test
    void 한번_발급된_로또는_번호를_변경할_수_없다() {
        Lotto lotto = LottoGenerator.getInstance().generateLotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> {
            lotto.getLottoNumbers().add(new LottoNumber(1));
        }).isInstanceOf(UnsupportedOperationException.class);

        assertThatThrownBy(() -> {
            lotto.getLottoNumbers().remove(1);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 당첨로또와_로또를_비교할수_있다() {
        WinningLotto winningLotto = LottoGenerator.getInstance().generateWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = LottoGenerator.getInstance().generateLotto(List.of(1, 2, 3, 4, 5, 7));

        assertThat(winningLotto.getRank(lotto)).isEqualTo(Rank.TWO);
    }
}
