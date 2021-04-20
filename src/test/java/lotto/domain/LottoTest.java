package lotto.domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    public void 로또_생성_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test
    public void 로또_번호_갯수_초과() {
        assertThatThrownBy(
                () -> new Lotto(Arrays.asList(1,2,3,4,5))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}