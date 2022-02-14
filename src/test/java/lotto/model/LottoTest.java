package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또는_숫자_여섯개() {
        Lotto lotto = new Lotto(Arrays.asList(
            new LottoNumber(2), new LottoNumber(4), new LottoNumber(8), new LottoNumber(41), new LottoNumber(15),
            new LottoNumber(20)
        ));
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    void 여섯개가_아닌_숫자가_들어오면_로또생성은_실패한다() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList( new LottoNumber(2), new LottoNumber(4),
            new LottoNumber(8), new LottoNumber(41), new LottoNumber(15))));
    }
}