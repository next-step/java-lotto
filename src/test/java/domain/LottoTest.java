package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 로또는_여섯개의_숫자를_가진다() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    void 로또는_서로다른_여섯개의_숫자를_가진다() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    void 한번_발급된_로또는_번호를_변경할_수_없다() {
        assertThatThrownBy(() -> {
            new Lotto().getLottoNumbers().add(new LottoNumber(1));
        }).isInstanceOf(UnsupportedOperationException.class);

        assertThatThrownBy(() -> {
            new Lotto().getLottoNumbers().remove(1);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 당첨로또와_로또를_비교할수_있다() {
        Lotto winningLotto = LottoGenerator.getInstance().generate(List.of(1,2,3,4,5,6));
        Lotto lotto = LottoGenerator.getInstance().generate(List.of(1,2,3,4,5,14));

        assertThat(winningLotto.matchCount(lotto)).isEqualTo(5);
    }


}
