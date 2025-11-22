package lottoGame.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumFactoryTest {

    @Test
    void 요청받은_갯수만큼_로또번호목록을_생성할_수_있다() {
        assertThat(
                LottoNumFactory.createLotto(6).size()
        ).isEqualTo(6);
    }

    @Test
    void 요청받은_갯수가_0이하면_예외처리_할_수_있다() {
        assertThatThrownBy(
                () -> LottoNumFactory.createLotto(0)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}