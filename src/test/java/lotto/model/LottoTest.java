package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또는_숫자_여섯개() {
        Lotto lotto = new Lotto(Arrays.asList(2, 4, 8, 41, 15, 20));
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 여섯개가_아닌_숫자가_들어오면_로또생성은_실패한다() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(2, 4, 8, 41, 15)));
    }
}